import re
import requests
import json
import urllib.request
from bs4 import BeautifulSoup
from Abstract import Abstract

class AllRecipes(Abstract):
    content_pattern = re.compile(r"""/recipes/\d+/\S*/\S*/""")
    @classmethod

    def __getText(self, url):
        r = requests.get(url)
        return r.text

    def __getContent(self, url):
        r = requests.get(url)
        return r.content

    def getRecipe(self, url):
        title = []
        totalTime = []
        cookTime = []
        prepTime = []

        soup = BeautifulSoup(self.__getContent(url), "html.parser") #gets URL one time per function use
        title.append(soup.find('h1').get_text())
        totalTime.append(soup.find('span', {'class': 'ready-in-time'}).get_text())
        cookTime.append(soup.find('time', {'itemprop': 'cookTime'}).get_text())     ##needs error checking (no cook time)
        prepTime.append(soup.find('time', {'itemprop': 'prepTime'}).get_text())     ##needs error checking (no prep time)
        ###get ingredients
        ingredients = []
        htmlIngredients = soup.findAll('span', {'itemprop': 'ingredients'})
        for i in htmlIngredients:
            ingredients.append(i.text)
            i.next_sibling
        del htmlIngredients
        ##get directions
        directions = []
        ol = soup.find('ol', {'class': 'list-numbers recipe-directions__list'})
        htmlDirections = ol.findAll('span', {'class': 'recipe-directions__list--item'})
        for item in htmlDirections:
            directions.append(item.text)
            item.next_sibling
        del htmlDirections
        ##Place recipe attributes into recipe [] in order of database fields
        recipe = [title, totalTime, cookTime, prepTime, ingredients, directions]
        return recipe

    def getDomain(self):
        domains = []
        content = self.__getText(self.getURL())
        result = re.findall(self.content_pattern, content)
        for domainPath in result:
            if domainPath not in domains:
                domains.append(domainPath)
        del result
        return domains

    def getRecipeUrls(self, url):
        soup = BeautifulSoup(self.__getText(url), "html.parser")
        js = json.loads(soup.select_one("script[type=application/ld+json]").text)
        jsUrls = [dct["url"] for dct in js["itemListElement"]]
        return jsUrls
