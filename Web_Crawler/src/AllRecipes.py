import re
import requests
import json
from bs4 import BeautifulSoup
from Abstract import Abstract


class AllRecipes():
    __content_pattern = re.compile(r"""/recipes/\d+/\S*/\S*/""")
    __url = "www.allrecipes.com"


    @classmethod
    def __getText(url):
        r = requests.get(url)
        return r.text

    @classmethod
    def __getContent(url):
        r = requests.get(url)
        return r.content

    @staticmethod
    def getRecipe(url):
        title = []
        totalTime = []
        cookTime = []
        prepTime = []

        soup = BeautifulSoup(__getContent(url).__func__(), "html.parser")  # gets URL one time per function use
        title.append(soup.find('h1').get_text())
        totalTime.append(soup.find('span', {'class': 'ready-in-time'}).get_text())
        cookTime.append(soup.find('time', {'itemprop': 'cookTime'}).get_text())  ##needs error checking (no cook time)
        prepTime.append(soup.find('time', {'itemprop': 'prepTime'}).get_text())  ##needs error checking (no prep time)
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

    @staticmethod
    def getDomain():
        domains = []
        content = __getText(__url).__func__()
        result = re.findall(content_pattern, content)
        for domainPath in result:
            if domainPath not in domains:
                domains.append(domainPath)
        del result
        return domains

    @staticmethod
    def getRecipeUrls(url):
        soup = BeautifulSoup(__getText(url), "html.parser")
        js = json.loads(soup.select_one("script[type=application/ld+json]").text)
        jsUrls = [dct["url"] for dct in js["itemListElement"]]
        return jsUrls
