package addrecipe1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;







public class addRecipe {

	//to handle gui's
	static JFrame frame1; // for frame
	static ActionListener listener; //to add action listener
	static JTextField text1; // for text box
	static JButton button1; 
	
	
	
    //variables 
    char response;
    String recipeName, prepTime, cookTime, totalTime, weightType;
    String ingredient, direction;
    double ingreAmount;
    int numIngre, numSteps;
    
 
    
    void addrecipe()
    {
    	
    	
    	//to handle future gui build
    	listener = null; // to initialize listener
        final int FIELD_WIDTH = 40; // adds the length of the button
        frame1 = new JFrame(); 	// frame for 1 entry
        frame1.setPreferredSize(new Dimension(1750,550)); // to change the size of the frame
    	
        text1 = new JTextField(FIELD_WIDTH); //to declare text box
        text1.setFont(new Font("Arial", Font.PLAIN, 40)); 	// to make font that user enters bigger

        button1 = new JButton("Enter Recipe Name.(press to Save)"); // button for user to enter 1 term
        button1.setFont(new Font("Arial", Font.PLAIN, 40)); //to make text in button bigger and different size
        
    	
        frame1.setLayout(new GridLayout(3, 30)); //makes the frame layout
        frame1.add(button1); // to add button
        frame1.add(text1);  // to add text box
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // manages components to size them correctly in frames
    	
        frame1.pack();
        //adds action listeners to all buttons in frames to make responsive
    	
        button1.addActionListener(listener);
        // button2.addActionListener(listener);
    	
    	
    	
    	
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
            
            //frame1.setVisible(true);
        	  	
        	//asks for the name of the recipe
            System.out.println("\nWhat is the name of this recipe?");
            recipeName = scan.next();
            
            scan.nextLine(); //to fix last newline character error 

            //asks for preptime
            System.out.println("\nHow long is the preperation time?");
            prepTime = scan.nextLine();
             
            //asks for cook time
            System.out.println("\nHow long is the cook time?");
            cookTime = scan.nextLine();
            
            //asks for total time
            System.out.println("\nHow long is the toal time to make the recipe?");
            totalTime = scan.nextLine();
            
            
            file.print(recipeName); //prints name of recipe to output file
            file.print(",");
            file.print(prepTime); //prints preparation time
            file.print(",");
            file.print(cookTime); //prints cook time
            file.print(",");
            file.println(totalTime); //prints cook time

            //asks for amount of ingredients for recipe
            System.out.println("\nHow many ingredients are in this recipe?");
            numIngre= scan.nextInt();
            
   
            //for loop to enter all ingredeients into array list.
            for(int x=1; x<=numIngre; x++)
            {
            	System.out.println("Enter ingredient number " + x );
            	ingredient = scan.next();

            	scan.nextLine();
                 
                System.out.println("Enter amount(will be based on type of ingredient)");
                ingreAmount = scan.nextDouble();

                
                file.print(ingredient); // add ingredient to output file
                file.print(",");
                file.println(ingreAmount); 
               
            }

            
            // This adds directions to the recipes. 
             
            //asks for amount of number of directions
            System.out.println("\nHow many steps is this recipe?");
            numSteps= scan.nextInt();
            
   
            //for loop to enter steps into array list.
            for(int x=1; x<=numSteps; x++)
            {
            	
             	scan.nextLine();
            	System.out.println("Enter direction number " + x );
            	direction = scan.nextLine();

           
            	
                file.println(direction); // add directions to output file
                //System.out.println("you entered" );
            }

            
            
            
            file.println("\n"); // to space out recipes

            
            //to print if user wants to enter another recipe & takes input
            System.out.print("To enter another recipe enter (y) to quit ");
            System.out.println("hit any other key.");
            response = scan.next().charAt(0);
            
           
            
        }//to end while loop

        scan.close(); // to close scanner
        
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
