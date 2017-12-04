from googleapiclient.discovery import build
import re
import AllRecipes
import sys, time
import csv
import os
from pprint import pprint


               #(search term, google api key, custom search engine id, other key values)

def googleSearch(search, api_key, cse_id, **kwargs):
    service = build("customsearch", "v1", developerKey=api_key)   #uses custom search engine
    results = service.cse().list(q=search, cx=cse_id, **kwargs).execute()
    return results['items']    #(search term, cse id, num, searchType, etc)

def customSearch(searchTerm):
    content_pattern = re.compile(r"""http://allrecipes.com/recipe/\d+/\S*""")
    api_key = "AIzaSyAgwnPor9TjUGjfzRnmCPjOLLQVariv4hU"  #google api key for CSE use
    cse_id = "017796283266161835558:_1vdw7w3wey"   #made a Custom Search Engine for allrecipes.com
                                                    #this is the ID for that search engine
    scraper = AllRecipes.AllRecipes("http://www.allrecipes.com") #initalize scraper

    Results = googleSearch(searchTerm, api_key, cse_id)
    pathToFile = "../PantryPlanner/src/pantryPlanner/databases/"
    #pathToFile = "C:\\Users\\Mom\\Desktop\\Software Engineering\\-CS3398-Mocha-F2017\\Recipe Display\\src\\"
    #opening CSV file
    with open(pathToFile+'recipe times.csv', 'a') as times, \
         open(pathToFile+'recipe ingredients.csv', 'a') as ingre, \
         open(pathToFile+'recipe directions.csv', 'a') as dir, \
         open(pathToFile+'recipe quantites.csv', 'a') as quant:
        #writing format to csv
        writerTimes = csv.writer(times, delimiter=',', quoting=csv.QUOTE_MINIMAL,
                                 lineterminator='\n')
        writerIngredients = csv.writer(ingre, delimiter=',', quotechar=' ',  quoting=csv.QUOTE_MINIMAL,
                                 lineterminator='\n')
        writerDirections = csv.writer(dir, delimiter=',', lineterminator='\n')

        writerQuantity = csv.writer(quant, delimiter=',', quotechar=' ', quoting=csv.QUOTE_MINIMAL, lineterminator ='\n')
        #fields
        # writerTimes.writerow(['Name', 'Total Time', 'Cook Time', 'Prep Time'])
        # writerIngredients.writerow(['Name','Ingredients'])
        # writerDirections.writerow(['Name', 'Directions'])
        # writerQuantity.writerow(['Name', 'Quantites'])

        for i in range(0, 10):   #number of results to scan for recipes
            if re.match(content_pattern, Results[i]['link']):   #scans urls and looks for "/recipe/"
                s = Results[i]['link'].encode('ascii', 'ignore')
                if s.endswith("print/"):
                    print("Discard")
                else:
                    print(Results[i]['link'])                       #if found, scrapes the page
                    thisRecipe = scraper.getRecipe(Results[i]['link'])
                    # thisRecipe[Name,totalTime,CookTime,PrepTime,ingredients, directions]
                    if(len(thisRecipe[4]) > 1):
                        timeslist = [thisRecipe[0], thisRecipe[1], thisRecipe[2], thisRecipe[3]]
                        ingredients = [thisRecipe[0], thisRecipe[4]]
                        directions = [thisRecipe[0],  thisRecipe[5]]
                        quantities = [thisRecipe[0], thisRecipe[6]]
                        writerTimes.writerow(timeslist[:])
                        times.flush()   #times wont write to file unless its flushed
                        writerQuantity.writerow(quantities[:])
                        quant.flush()
                        writerIngredients.writerow(ingredients[:])
                        ingre.flush()
                        writerDirections.writerow(directions[:])
                        dir.flush()
                        time.sleep(1)   #prevents attack on webserver
                    else:
                        print("recipe discarded! not enough ingredients!")
        times.close()   #closes files
        ingre.close()
        dir.close()
        quant.close()

if __name__ == '__main__':
    print("Starting Search...")
    # please do not add moore custom searches.
    # This is just to show that the function works.
    # will use just the function when importing to JAVA.