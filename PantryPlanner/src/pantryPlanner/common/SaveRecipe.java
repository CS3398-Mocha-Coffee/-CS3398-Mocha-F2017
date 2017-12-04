package pantryPlanner.common;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;


public class SaveRecipe{

	private static ArrayList<List<String>> parcedFile = new ArrayList<List<String>>();
	private static Hashtable<String, Double> ingredientsHash = new Hashtable<String, Double>(); 
	ArrayList<String> stepsArrayList = new ArrayList<String>();
	
    //variables 
    char response;
    String recipeName, prepTime, cookTime, totalTime, weightType;
    String ingredient, direction;
    String ingreAmount;
    int numIngre, numSteps;
    
    void saveRecipeToCSV() throws IOException
    {
    	File log = new File("userrecipes.csv");
    	        
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
        	BufferedReader br = new BufferedReader(new FileReader("userrecipes.csv"));
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
            System.out.println("\nHow long is the total time to make the recipe?");
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
            	file.write("-");
            	
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
            	file.write("-");
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
                file.write("-");
                
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
     
    void readRecipesFrCSV() throws Exception {
    	
    	//to get how many rows are in the CSV file//
    	BufferedReader br = new BufferedReader(new FileReader("userrecipes.csv"));
    	String input;
    	int count = 0;
    	
    	while((input = br.readLine()) != null)
	     {
	        count++;
	     }
    	////////////////////////////////////////////
    	
    	
      	//header to show all the recipes read from the .csv file
    	System.out.println("Name\t\t"+"Prep Time\t"+"Cook Time\t"+"Total Time\t"+"Ingredients/Measurements\t"+"Steps");
    	
    	
    	parcedFile = CSVUtils.getParsed("userrecipes.csv"); //change csvScraper to CSVUtils
    	// Parse the information in each line and set the fields of the ingredients 
    	// before putting them in a Hashtable.
    	for (int i = 0; i <= count-1; i++) {  //this for loop increments rows of csv file
    		List<String> item = parcedFile.get(i);
    		
    		if( i==0) //skips header of the CSV file aka first row
    			System.out.print("");
    		else 
    		{
    			String nameString = item.get(0); //to get name
    			String prepString = item.get(1); //to get prep time
    			String cookString = item.get(2); //to get cook time
    			String totaltimeString = item.get(3); //to get total time
    			
    			//prints name, prep, cook, total times
    			System.out.print(nameString+"\t\t");
    			System.out.print(prepString+"\t\t");
    			System.out.print(cookString+"\t\t");
    			System.out.print(totaltimeString+"\t\t");
    			
    			
    			
    			String ingredientString = item.get(4); //stores ingredients from the recipe into single string
    			String measurementString = item.get(5); //stores measurements from the recipe into single string
    			String stepsString = item.get(6); //stores steps
    			
    			
    			// to get the number of times '-' appears in string for ingre and measurements strings//
    			int counter = 0;
    			for( int y=0; y<ingredientString.length(); y++ ) {
    			    if( ingredientString.charAt(y) == '-' ) {
    			        counter++;
    			    } 
    			}
    			////////////////////////////////////////////////////////////////////////////////////////
    			
    			
    			// to get number times '-' appears in steps string
    			int counter2 = 0;
    			for( int y=0; y<stepsString.length(); y++ ) {
    			    if( stepsString.charAt(y) == '-' ) {
    			        counter2++;
    			    } 
    			}
    			///////////////////////////////////////////////////
    			
    			//splits the strings after where '-' appears in string
    			String[] parts1 = ingredientString.split("-");
    			String[] parts2 = measurementString.split("-");
    			String[] parts3 = stepsString.split("-");
    			
    			
    			// for loop prints that separates ingre and measurement string into multiple strings
    			// also adds the ingredient and measurement to a hash table
    			for(int z=0; z<counter;z++) {
    				
    				String ingre = parts1[z]; //to print string part separated by -
    				String measu = parts2[z];
    				System.out.print(ingre+" ");
    				System.out.print(measu+",");
    				
    				double value = Double.parseDouble(measu);
    				ingredientsHash.put(ingre, value);
    				
    			}
    			
    			
    			System.out.print("\t\t\t");
    			//this for loop adds steps to array list
    			for(int y=0; y<counter2; y++)
    			{
    				
    				String step = parts3[y];
    				System.out.print(step+",");
    				stepsArrayList.add(step);
    				
    			}
    			
    			System.out.println();
    			//System.out.println(ingredientsHash); // to print the values  in hash table
    			//System.out.println(stepsArrayList);  //to print values in array list.
    			
    		}
    	}
    }
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  SaveRecipe test1 = new SaveRecipe();
	        
	      //test1.saveRecipeToCSV(); //to test saveRecipe file
		 test1.readRecipesFrCSV();
		
	}
}//end of class