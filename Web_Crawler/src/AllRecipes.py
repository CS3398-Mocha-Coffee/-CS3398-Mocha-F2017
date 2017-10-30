import re
import requests
import json
from bs4 import BeautifulSoup
from Abstract import Abstract
from pprint import pprint


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
        try:
            title.append(soup.find('h1').get_text())
        except AttributeError:
            title.append('None')
        try:
            totalTime.append(soup.find('span', {'class': 'ready-in-time'}).get_text())
        except AttributeError:
            totalTime.append('0 m')
        try:
            cookTime.append(soup.find('time', {'itemprop': 'cookTime'}).get_text())
        except AttributeError:
            cookTime.append('0 m')
        try:
            prepTime.append(soup.find('time', {'itemprop': 'prepTime'}).get_text())
        except AttributeError:
            prepTime.append('0 m')
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
        data = soup.select_one("script[type=application/ld+json]").text
        data = data.strip('\\r\\n')
        data = data.strip()
        data = data.rstrip(';')
        decoded_data = json.loads(data)
        recipe_urls = [dct["url"] for dct in decoded_data["itemListElement"]]
        return recipe_urls









