package addrecipe1;
//import recipe.display.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class addRecipe {

	private static ArrayList<List<String>> parcedFile = new ArrayList<List<String>>();
	private static Hashtable<String, Integer> ingredients = new Hashtable<String, Integer>(); 
	
    //variables 
    char response;
    String recipeName, prepTime, cookTime, totalTime, weightType;
    String ingredient, direction;
    String ingreAmount;
    int numIngre, numSteps;
    
    void addrecipe() throws IOException
    {
    	File log = new File("User-Inputted-Recipes.csv");
    	        
        BufferedWriter file = null;
		FileWriter file1 = null;

        //create scanner to read input & asks user if they want to enter recipe
        Scanner scan =  new Scanner(System.in);
        System.out.print("Do you want to add your own recipe. Yes or No?");
        System.out.println("(enter y or n)");
        response = scan.next().charAt(0);

        try {
        	//allows to append current file instead of overwrite
            file1 = new FileWriter(log, true); 
            file = new BufferedWriter(file1);
            
          

        //does while loop if you want enter new recipe. ends o/w
        while(response == 'y' || response == 'Y' )
        {
        	BufferedReader br = new BufferedReader(new FileReader("User-Inputted-Recipes.csv"));
        	if (br.readLine() == null) {
        		file.write("Name,Prep Time,Cook Time, Total Time,Ingredients,Measurement,Steps");
        	}
              	
        	 
        	scan.nextLine(); //to fix last newline character error 
        	//Recipe recipe = new Recipe();
        	//asks for the name of the recipe
            System.out.println("\nWhat is the name of this recipe?");
            recipeName = scan.nextLine();
            //recipe.setName(recipeName);
            
            //asks for preparation time
            System.out.println("\nHow long is the preperation time?");
            prepTime = scan.nextLine();
           // recipe.setName(prepTime);
             
            //asks for cook time
            System.out.println("\nHow long is the cook time?");
            cookTime = scan.nextLine();
           // recipe.setCookTime(cookTime);
            
            //asks for total time
            System.out.println("\nHow long is the toal time to make the recipe?");
            totalTime = scan.nextLine();
           // recipe.setTotalTime(totalTime);
            
            //prints data is just got from user to a .csv file
            file.newLine();
            file.write(recipeName); 
            file.write(",");		//prints space on excel spreadsheet
            file.write(prepTime); 
            file.write(",");
            file.write(cookTime); 
            file.write(",");
            file.write(totalTime); 
            file.write(",");
          

            //asks for amount of ingredients for recipe
            System.out.println("\nHow many ingredients are in this recipe?");
            numIngre = scan.nextInt();
            
            List<String> ingredients = new ArrayList<String>(); //make list to store ingredients
            
            //for loop to enter all ingredients into .csv file
            for(int x=1; x<=numIngre; x++)
            {
            	scan.nextLine();
            	
            	System.out.println("Enter ingredient number " + x );
            	ingredient = scan.nextLine();
            	ingredients.add(ingredient); //to add to array list
            	
            	
            	file.write(ingredient); // add ingredient to output file
            	file.write(":");
            	
            }
           // recipe.setIngredients(ingredients);
            
            file.write(",");
            
            List<String> quantities = new ArrayList<String>(); //array list to hold quantities
            
            for(int y=1; y<=numIngre; y++)
            {
                System.out.println("Enter amount for ingredient #" + y);
                ingreAmount = scan.nextLine();
                quantities.add(ingreAmount); // add quantities to array list 
                
                file.write(ingreAmount); 
            	file.write(":");
            }
          //  recipe.setQuantities(quantities);
            
            file.write(","); // skip cell for steps
            
            
            // This adds directions to the recipes. 
            //asks for amount of number of directions
            System.out.println("\nHow many steps is this recipe?");
            numSteps = scan.nextInt();
            
            //for loop to enter steps into array list.
            for(int x=1; x<=numSteps; x++)
            {
             	scan.nextLine();
            	System.out.println("Enter direction number " + x );
            	direction = scan.nextLine();

                file.write(direction); // adds directions to .csv file
                file.write(":");
                
            }

            //to print if user wants to enter another recipe & takes input
            System.out.print("To enter another recipe enter (y) to quit ");
            System.out.println("hit any other key.");
            response = scan.next().charAt(0);
             
        }//to end while loop

        file.flush();
        scan.close(); // to close scanner
        
        }//to end try function
        catch(IOException e){
        	e.printStackTrace();
        }
        finally{
            
            	if(file1 != null)
            		file1.close();
            	
            	if(file != null)
            		file.close();
            
        }
     }     
     
    
    void readRecipe1() throws Exception {
    	
    	parcedFile = csvScraper.getParsed("User-Inputted-Recipes"); //change csvScraper to CSVUtils
    	// Parse the information in each line and set the fields of the ingredients 
    	// before putting them in a Hashtable.
    	for (int i = 0; i < parcedFile.size(); i++) {
    		List<String> item = parcedFile.get(i);
    		
    		if( i==0)
    			System.out.println("done");
    		else 
    		{
    		for (int j = 0; j < 7;j++) {
    			
    		item.get(4);
    		System.out.println(item.get(4));
    		
    		
    			
    		//item.get(0), item.get(1), item.get(2);
    		}
    			
    			
    		}
    	}
    }
    
}//end of class
