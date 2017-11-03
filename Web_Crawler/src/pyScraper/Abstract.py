import requests


class Abstract():
    def __init__ (self, url):
        r = requests.get(url)
        if(r.status_code == 200):
            self.url = url
        else:
            print("ERROR! Unable to process request!")

    def getURL(self):
        return self.url