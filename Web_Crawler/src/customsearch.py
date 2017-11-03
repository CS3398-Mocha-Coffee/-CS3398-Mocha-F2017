from googleapiclient.discovery import build
import re
import AllRecipes
import sys, time
import csv
from pprint import pprint
from bs4 import BeautifulSoup

def googleSearch(search, api_key, cse_id, **kwargs):
    service = build("customsearch", "v1", developerKey=api_key)
    results = service.cse().list(q=search, cx=cse_id, **kwargs).execute()
    return results['items']

def customSearch(searchTerm):
    content_pattern = re.compile(r"""http://allrecipes.com/recipe/\d+/\S*""")
    api_key = "AIzaSyAgwnPor9TjUGjfzRnmCPjOLLQVariv4hU"
    cse_id = "017796283266161835558:_1vdw7w3wey"
    scraper = AllRecipes.AllRecipes("http://www.allrecipes.com")

    Results = googleSearch(searchTerm, api_key, cse_id)
    # pprint(testResults)
    with open('custom times.csv', 'w') as times, \
         open('custom ingredients.csv', 'w') as ingre, \
         open('custom directions.csv', 'w') as dir:
        #writing format to csv
        writerTimes = csv.writer(times, delimiter=',', quotechar='|', quoting=csv.QUOTE_MINIMAL,
                                 lineterminator='\n')
        writerIngredients = csv.writer(ingre, delimiter=',', quotechar='|', quoting=csv.QUOTE_MINIMAL,
                                 lineterminator='\n')
        writerDirections = csv.writer(dir, delimiter=',', lineterminator='\n')
        #fields
        writerTimes.writerow(['Name', 'Total Time', 'Cook Time', 'Prep Time'])
        writerIngredients.writerow(['Name', 'Ingredients'])
        writerDirections.writerow(['Name', 'Directions'])

        for i in range(0, 10):
            if re.match(content_pattern, Results[i]['link']):
                print(Results[i]['link'])
                thisRecipe = scraper.getRecipe(Results[i]['link'])
                timeslist = [thisRecipe[0], thisRecipe[1], thisRecipe[2], thisRecipe[3]]
                ingredients = [thisRecipe[0], thisRecipe[4]]
                directions = [thisRecipe[0], thisRecipe[5]]
                writerTimes.writerow(timeslist[:])
                times.flush()
                writerIngredients.writerow(ingredients[:])
                writerDirections.writerow(directions[:])
                time.sleep(1)
        times.close()
        ingre.close()
        dir.close()

if __name__ == '__main__':
    customSearch("Spaghetti")








