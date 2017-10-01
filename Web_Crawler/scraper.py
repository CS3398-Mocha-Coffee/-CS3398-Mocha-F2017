from bs4 import BeautifulSoup  #html parser
import requests #URL navigator


HEADERS = {
   'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36'
}

ingredients = []
r = requests.get("http://allrecipes.com/recipe/73350/shrimp-burritos")


if (r.status_code == 200):
    content = r.content
    soup = BeautifulSoup(content, "html.parser")

    name = soup.find('h1').get_text()
    totalTime = soup.find('span', {'class': 'ready-in-time'}).get_text()
    cookTime = soup.find('time', {'itemprop': 'cookTime'}).get_text()
    prepTime = soup.find('time', {'itemprop': 'prepTime'}).get_text()
    ingredients_list = soup.findAll('span', {'itemprop': 'ingredients'})
    for x in ingredients_list:
        ingredients.append(x.text)
        x.next_sibling
    instructions = soup.findAll('span', {'class': 'recipe-directions_list--item'})

else:
    print("Error! Bad URL!")
    exit()


print("title: ", name)
print("Total time: ", totalTime)
print("Prep time: ", prepTime)
print("Cook Time: ", cookTime)
print("Ingredients: ", end = '')
for item in ingredients:
    print (item, sep = '', end =',', flush = True)
print("\nInstructions: ", instructions)




