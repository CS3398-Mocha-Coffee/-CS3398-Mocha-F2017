package recipes;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class toAddRecipes {

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
    String ingreAmount, measurementType;
    int numIngre, numSteps;
    
    void addrecipe() throws IOException
    {
    	/*
    	to handle future gui build
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
    	*/
    	
    	
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
            //frame1.setVisible(true);
        	  	
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
            file.newLine();

            //asks for amount of ingredients for recipe
            System.out.println("\nHow many ingredients are in this recipe?");
            numIngre = scan.nextInt();
             
            //for loop to enter all ingredients into .csv file
            for(int x=1; x<=numIngre; x++)
            {
            	scan.nextLine();
            	
            	System.out.println("Enter ingredient number " + x );
            	ingredient = scan.nextLine();

                System.out.println("Enter amount(will be based on type of ingredient)");
                ingreAmount = scan.nextLine();

                System.out.println("Enter measurement type(will be based on type of ingredient)");
                measurementType = scan.nextLine();
                
                file.write(ingredient); // add ingredient to output file
                file.write(",");
                file.write(ingreAmount); 
                file.newLine();
                file.write(measurementType); 
                file.newLine();
            }

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
            	file.newLine();
            }

            file.newLine();

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