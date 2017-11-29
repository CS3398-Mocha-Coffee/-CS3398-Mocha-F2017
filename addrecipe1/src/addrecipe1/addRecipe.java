package addrecipe1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class addRecipe {

    /* to handle future gui's
	static JFrame frame1; // for frame
	static ActionListener listener; //to add action listener
	static JTextField text1; // for text box
	static JButton button1; 
	*/
	
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
        	 
        	//asks for the name of the recipe
            System.out.println("\nWhat is the name of this recipe?");
            recipeName = scan.nextLine();
            
            //asks for preparation time
            System.out.println("\nHow long is the preperation time?");
            prepTime = scan.nextLine();
             
            //asks for cook time
            System.out.println("\nHow long is the cook time?");
            cookTime = scan.nextLine();
            
            //asks for total time
            System.out.println("\nHow long is the toal time to make the recipe?");
            totalTime = scan.nextLine();
            
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
             
            //for loop to enter all ingredients into .csv file
            for(int x=1; x<=numIngre; x++)
            {
            	scan.nextLine();
            	
            	System.out.println("Enter ingredient number " + x );
            	ingredient = scan.nextLine();
            	
            	file.write(ingredient); // add ingredient to output file
            	file.write(":");
            	
            }
            file.write(",");
            for(int y=1; y<=numIngre; y++)
            {
                System.out.println("Enter amount for ingredient #" + y);
                ingreAmount = scan.nextLine();
                file.write(ingreAmount); 
            	file.write(":");
            }
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
           // System.out.println(e);
            //System.out.println("Failure");
        	e.printStackTrace();
        }
        finally{
            
            	if(file1 != null)
            		file1.close();
            	
            	if(file != null)
            		file.close();
            
        }
     }     
     
}
