import time, sys
import AllRecipes
from pyprogress import *
import csv
if __name__ == '__main__':
    allUrls = []
    AllRecipes.Abstract.url = "http://www.allrecipes.com"
      domain_list = AllRecipes.AllRecipes.getDomain()
    #progress bar for crawl:
    pb = ProgressBar(len(domain_list), name = "Crawling AllRecipes.com",
                     timecount=False, completionprediction=True, colored=True)
    pb.begin()
    for path in domain_list:
        recipeUrls = x.getRecipeUrls(x.getURL()+path) #returns a list of urls for each catagory
        allUrls.append(recipeUrls) #creates a 2D list (list within a list) of all recipes
        time.sleep(1) #AllRecipes robots.txt allows crawl-delay: 1
        pb.inc()
    pb.end()

    with open("recipes.csv", "w") as outcsv:
        #config writer to write in csv
        writer = csv.writer(outcsv, delimiter = ',', quotechar = '|', quoting = csv.QUOTE_MINIMAL, lineterminator = '\n')
        writer.writerow(['Name', 'Total Time', 'Cook Time', 'Prep Time'])
        for recipeList in allUrls:
            for recipe in recipeList:                   #Does not write neatly into csv, need to find fix!
                print("Current Recipe: ", recipe)
                writer.writerow(x.getRecipe(recipe))   ##writes each recipe to a row in csv.
                time.sleep(1) ##DO NOT REMOVE OR THIS ATTACKS WEBSERVER WITH DOS-Attack

