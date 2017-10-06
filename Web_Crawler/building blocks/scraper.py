from bs4 import BeautifulSoup  #html parser
import requests #URL navigator


HEADERS = {   #some websites require a user agent to be spoofed cause they dont like bots :(
              # This is here in case it is needed
   'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36'
}

directions = []  #directions are extracted into array
ingredients = [] #ingredients are extracted into array
r = requests.get("http://allrecipes.com/recipe/14597/slovak-stuffed-cabbage/") #grabs contents from given URL


if (r.status_code == 200):   #if status_code == 200 then the request was pulled with no errors
    content = r.content      #grabs the contents of URL
    soup = BeautifulSoup(content, "html.parser")   #parses contents into readable format

    name = soup.find('h1').get_text()   #extracts the Recipe Name
    totalTime = soup.find('span', {'class': 'ready-in-time'}).get_text()   #extracts the total time for recipe
    cookTime = soup.find('time', {'itemprop': 'cookTime'}).get_text()      #extracts the cook time for recipe
    prepTime = soup.find('time', {'itemprop': 'prepTime'}).get_text()      #extracts the prep time for recipe
    ingredients_list = soup.findAll('span', {'itemprop': 'ingredients'})   #extracts the ingredients (w/ html tags) into a list
    for x in ingredients_list:       #traverses ingredients list
        ingredients.append(x.text)   #extracts text from <html tag> and appends to ingredients list
        x.next_sibling   #jumps to next <span> html tag
    del ingredients_list[:]
    ol = soup.find('ol', {'class': 'list-numbers recipe-directions__list'})   #cooking directions are stored within <ol>
    instructions = ol.findAll('span', {'class': 'recipe-directions__list--item'}) #access cooking instructions via <ol>
    for i in instructions:         #traverses instructions list
        directions.append(i.text)  #extracts text from <html tag> and appends to ingredients list
        i.next_sibling   #jumps to next <span> html tag
    del instructions[:]

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
print("\nDirections: ", end = '')
for dir in directions:
    print (dir, end ='\n\n')

