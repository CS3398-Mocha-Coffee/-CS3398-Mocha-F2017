import time, sys
import AllRecipes
from pyprogress import *
import csv
if __name__ == '__main__':
    allUrls = []
    allRecipes = []
    x = AllRecipes.AllRecipes("http://www.allrecipes.com")
    domain_list = x.getDomain()
    #print(domain_list)
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

    with open('recipe times.csv', 'w') as times, open ('recipe ingredients.csv', 'w') as ingre, open ('recipe directions.csv', 'w') as direc:
        #config writer to write in csv
        writerTimes = csv.writer(times, delimiter=',', quotechar='|', quoting=csv.QUOTE_MINIMAL, lineterminator='\n')
        writerIngredients = csv.writer(ingre,delimiter=',', quotechar='|', quoting=csv.QUOTE_MINIMAL, lineterminator='\n')
        writerDirections = csv.writer(direc, delimiter = ',',lineterminator = '\n')
        #HEADERS
        writerTimes.writerow(['Name', 'Total Time', 'Cook Time', 'Prep Time'])
        writerIngredients.writerow(['Name', 'Ingredients'])
        writerDirections.writerow(['Name', 'Directions'])
        #write to files
        for recipeList in allUrls:
            for recipe in recipeList:                   #Does not write neatly into csv, need to find fix!
                print("Current Recipe: ", recipe)
                thisRecipe = x.getRecipe(recipe)
                timeslist = [thisRecipe[0],thisRecipe[1],thisRecipe[2],thisRecipe[3]]
                ingredients = [thisRecipe[0],thisRecipe[4]]
                directions = [thisRecipe[0], thisRecipe[5]]
                writerTimes.writerow(timeslist[:])
                times.flush()
                writerIngredients.writerow(ingredients[:])
                writerDirections.writerow(directions[:])
                time.sleep(1) ##DO NOT REMOVE OR THIS ATTACKS WEBSERVER WITH DOS-Attack
        times.close()
        ingre.close()
        direc.close()
