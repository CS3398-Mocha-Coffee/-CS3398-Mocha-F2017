<<<<<<< HEAD
Team Mocha: Pantry Planner README
Pantry Planner is a desktop application that gives the user real-time access to the food available to them in their pantry.  As well as possible recipes for the food available.  Recipes are scraped in from the internet and stored in databases included with the application.


OVERALL UPDATE - 03DEC2017 All code is now in common, database, views, or resources.  This will be pushed to the MASTER branch.

***PANTRY UPDATES***
UPDATE - 08NOV2017 Pantry code integrated and now in Pantry Planner on the development branch.

***RECIPE UPDATES***
UPDATE - 08NOV2017 Recipe database built out and ready for intergration.  Web scrapper and parsing program is now in the development branch.

***GUI UPDATES***
UPDATE - 03DEC2017  Dropped pull down menu from pantryAddMenu frame.  Changed text areas to text fields in recipeAddMenu.

UPDATE - 02DEC2017 Added in the variables to pass strings back and forth and display info. Filled out the pull down menu to match pantry.

UPDATE - 01DEC2017 recipeAddMenu:  added action listners for the radio buttons and assigned the correct string to variable category.
pantryAddMenu:  added itemGroup array for the JComboBox.
On all frames:  added functionality to clear JTextFeilds and radio buttons on button clicks.

UPDATE - 20NOV2017 Met up with Arthur and laid out the plan for combinding the recipe database and methods into the GUI.
Added action listeners and changed category from a pull down to 4 radio buttons.

UPDATE - 19NOV2017 I added the frames for Recipe: Add, Remove and Search.  I will add in the action listeners when I link up each frame and button/s.

UPDATE - 08NOV2017 I added action listeners to all buttons for integration. I have also added a package pantryPlanner.databases this is where databases will go for the app.

UPDATE - 04NOV2017 I completely restructured the code for the GUI. I have now added three classes to the src under pantryPlanner they are as follows: common: this is where code that is not GUI related goes. views: this is where the GUI is located. resources: this is where you put .png for logos or other resources to keep all data enclosed in the app. This should make the integration of the recipe and pantry databases easier.




***TODO Section***
***TODO: Need to link both the recipe/pantry menu buttons to desired actions with the databases





***Icon Creator Credit***
recipe(16, 32, 128): Icon made by David Lanham Freeware non-commercial from www.findicons.com recipeBook128: Icon made by Freepik from www.flaticon.com coveredFoodTray(16, 32, 128): Icon made by Freepik from www.flaticon.com pantry128: Icon made by Freepik from www.flaticon.com
=======
# -CS3398-Mocha-F2017

## To Be Completed:
- [ ] Connect all inventory manipulation methods to GUI
- [ ] INTEGRATE CODE INTO DEVELOP BRANCH

## Completed:
- [x] Create CSVUtils to read data from a CSV file
- [x] Create ingredient class to store ingredient details
- [x] Create ingredients database and a method of obtaining data
- [x] Create inventory class with methods to add/edit/remove ingredient objects
- [x] Create Comparitor class to compare two inventory objects
  - [x] Create method to compare two ingredients and find difference in qty
  - [x] Create method of finding substitutes for recipe ingredents
  - [x] Create method of unifying and converting units
- [x] Create method of displaying an itemized list of ingredients in an inventory object, sorted by ingredient category
- [x] Create classes for each General Ingredient Category
- [x] Create methods of storing and restoring pantry and shopping list data when closing/opening the app
- [x] Web Scraper UML Design
- [x] Create Ingredients Database
- [x] Web Crawl/Scrape into database
- [x] Recipe Search
- [x] Custom Recipe code successfully integrated (Abel & Arthur)

>>>>>>> master
