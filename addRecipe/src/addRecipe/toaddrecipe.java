
package addRecipe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*******************************************************************************
* The following class asks the user if they want to enter a recipe. If they say 
* yes it asks them for the name of the recipe they are entering. Then asks for 
* the number of ingredients and asks the user to input all those ingredients.
* All the input from the user is then stored in a .csv file which can be opened
* in excel. The idea is to store them in the .csv file and then can be accessed 
* later whenever we need all their custom recipes again.
*******************************************************************************/
public class toaddrecipe {

        //variables 
        char response;
        String recipeName, ingredient;
        int numIngre;
        
        void addrecipe()
        {
           String filename = "User-Inputted-Recipes.csv"; // to name output file
            PrintWriter file = null;

            //create scanner to read input & asks user if they want to enter recipe
            Scanner scan =  new Scanner(System.in);
            System.out.print("Do you want to add your own recipe. Yes or No?");
            System.out.println("(enter y or n)");
            response = scan.next().charAt(0);

            try {
                file = new PrintWriter(filename); // bring up file

            //does while loop if you want enter new recipe. ends o/w
            while(response == 'y' || response == 'Y' )
            {
                //asks for the name of the recipe
                System.out.println("\nWhat is the name of this recipe?");
                recipeName = scan.next();

                file.println(recipeName); //prints name of recipe to output file
                file.println("Ingredients"); // to name when ingredients start

                //asks for amount of ingredients for recipe
                System.out.println("\nHow many ingredients are in this recipe?");
                numIngre= scan.nextInt();

                List<String> ingreList = new ArrayList<>(); //to hold ingredients

                //for loop to enter all ingredeients into array list.
                for(int x=1; x<=numIngre; x++)
                {
                    System.out.println("Enter ingredient number " + x );
                    ingredient = scan.next();

                    ingreList.add(ingredient);
                    file.println(ingredient); // add ingredient to output file
                    //System.out.println("you entered" );
                }

                file.println("\n"); // to space out recipes

                //to print if user wants to enter another recipe & takes input
                System.out.print("To enter another recipe enter (y) to quit ");
                System.out.println("hit any other key.");
                response = scan.next().charAt(0);
            }//to end while loop

            }//to end try function
            catch(IOException e){
                System.out.println(e);
                System.out.println("Failure");
            }
            finally{
                file.flush();
            }
         }         
}

     
    

