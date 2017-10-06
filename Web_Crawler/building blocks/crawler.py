from bs4 import BeautifulSoup
import requests
import re
import time
import json

HEADERS = {   #some websites require a user agent to be spoofed cause they dont like bots :(
              # This is here in case it is needed
   'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36'
}


def get_page(url):
    r = requests.get(url)
    if r.status_code == 200:
        content = r.text
        return content
    else:
        print("ERROR! Unable to process request!")
        exit()

def get_domain(url):
    content = get_page(url)   #grabs content from page
    content_pattern = re.compile(r"""/recipes/\d+/\S*/\S*/""") #Uses a regex to find the path for each recipe catagory
    result = re.findall(content_pattern, content)              #Does not find all catagories (yet) due to redundant links
    return result                                              #But it still crawls a lot of catagories/recipes in the end

def get_recipe(url):
    soup = BeautifulSoup(get_page(url), "html.parser")                  #allrecipes.com stores recipe urls in json list
    recipe_json = json.loads(soup.select_one("script[type=application/ld+json]").text) #this selects the url list
    recipe_urls = [dct["url"] for dct in recipe_json["itemListElement"]] #this takes url at every ListItem position
    return recipe_urls                                                   #and stores it into recipe_urls list as a string


###DO NOT REMOVE DELAY
if __name__ == '__main__':
    domain = []
    start_url = 'http://allrecipes.com' #start url that we will attach directory path to
    domain_list = get_domain(start_url) #gets the directory paths
    for d in domain_list: #filter out redundant paths
        if d not in domain:
            domain.append(d)
    del domain_list       #deletes allocated memory from domain_list that we transferred to domain []
    for path in domain:
        print(start_url+path)
        t0 = time.time()                     #dynamic delay to prevent server side network congestion
        recipe_url = get_recipe(start_url+path)
        print(recipe_url)
        response_delay = time.time() - t0    #checks the response time of server (intentional delay)
        time.sleep(10*response_delay)        #wait 10x longer than it took server to respond