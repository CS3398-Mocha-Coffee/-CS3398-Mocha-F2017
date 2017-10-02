from bs4 import BeautifulSoup
import requests
import re
import time
#THIS IS INCOMPLETE. does not efficiently grab URL paths (will grab same path multiple times)
                    #Need to find more effiencent way of crawling
                    #only crawls food catagories so far
def get_page(url):
    r = requests.get(url)
    if r.status_code == 200:
        content = r.text
        return content
    else:
        print("ERROR! Unable to process request!")
        exit()

def get_domain(url):
    content = get_page(url)
    content_pattern = re.compile(r"""/recipes/\d+/\S*/""")
    result = re.findall(content_pattern, content)
    #print(result)
    return result

#def get_recipe(url):


###DO NOT REMOVE DELAY
if __name__ == '__main__':
    start_url = 'http://allrecipes.com'
    domain_list = get_domain(start_url)
    for path in domain_list:   #dynamic delay to prevent server side network congestion
        print(start_url+path)
        t0 = time.time()
        content = get_domain(start_url+path)
        print(content)
        response_delay = time.time() - t0
        time.sleep(10*response_delay) #wait 10x longer than it took server to respond