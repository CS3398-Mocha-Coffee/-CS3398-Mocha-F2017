from bs4 import BeautifulSoup  #html parser
import requests #URL navigator


HEADERS = {   #some websites require a user agent. This is here in case it is needed
   'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36'
}

ingredients = [] #ingredients are extracted into array (line 23)
r = requests.get("http://allrecipes.com/recipe/73350/shrimp-burritos") #grabs contents from given URL


if (r.status_code == 200):   #if status_code == 200 then the request was pulled with no errors
    content = r.content      #grabs the contents of URL
    soup = BeautifulSoup(content, "html.parser")   #parses contents into readable format

    name = soup.find('h1').get_text()   #extracts the Recipe Name
    totalTime = soup.find('span', {'class': 'ready-in-time'}).get_text()   #extracts the total time for recipe
    cookTime = soup.find('time', {'itemprop': 'cookTime'}).get_text()      #extracts the cook time for recipe
    prepTime = soup.find('time', {'itemprop': 'prepTime'}).get_text()      #extracts the prep time for recipe
    ingredients_list = soup.findAll('span', {'itemprop': 'ingredients'})   #extracts the ingredients (w/ html tags) into a list
    for x in ingredients_list:       #traverses list
        ingredients.append(x.text)   #extracts text from <html tag> and appends to ingredients list
        x.next_sibling   #jumps to next <span> html tag
    instructions = soup.findAll('span', {'class': 'recipe-directions_list--item'})

else:
    print("Error! Bad URL!")   #if status_code != 200 then request pulled with errors
    exit()   #exit program


print("title: ", name)
print("Total time: ", totalTime)
print("Prep time: ", prepTime)
print("Cook Time: ", cookTime)
print("Ingredients: ", end = '')
for item in ingredients:
    print (item, sep = '', end =',', flush = True)
print("\nInstructions: ", instructions)   #*Instructions are not being pulled properly from HTML***FIX THIS***




