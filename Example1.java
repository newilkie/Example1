package wilkien.MainApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author nathanwilkie
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //menu program selection
        Scanner sc = new Scanner(System.in); //creating a scanner for detecting inputs

        //using a while loop to make sure the program gets the correct input. 
        while (true) {
            //creating the selection menu for the user so that they know their options.
            System.out.println("1 - Hello World!");
            System.out.println("2 - Integer Divider");
            System.out.println("3 - Word Sorter");
            System.out.println("4 - Hello Files");
            System.out.println("5 - Exit");
            //System.out.println("6 - Program 6");
            System.out.println("Please select a program you would like to run (1-5).");
            int programSelection = sc.nextInt();

            System.out.println("You have selected " + programSelection + ".");

            //initialize block
            String name = "";

            //using if else statements to run the specific code for each program
            if (programSelection == 1) {
                System.out.println("Thanks for selecting program 1");
                System.out.println("Hi and welcome to the module 1 application. What is your name?");
                name = sc.next(); //used a .next because .nextline skips the entry and goes to a new line and would make the formatting odd.
                System.out.println("Hello, " + name + "!");
                System.out.println("Returning to selection module");
                System.out.println("");
            } else if (programSelection == 2) {
                System.out.println("Thanks for selecting program 2");
                System.out.println(name + " please enter two integers (whole numbers):");
                int num1 = sc.nextInt(); //asking for the first integer.
                int num2 = sc.nextInt(); //asking for the second integer.
                int div1 = num1 / num2; //calculating the division of the first integer by the second integer.
                int rem1 = num1 % num2; //calculating the remainder of the first integer when divided by the second integer.
                System.out.println(num2 + " goes into " + num1 + " " + div1 + " times."); //print statement of result of division.
                System.out.println(num1 + " when divided by " + num2 + " has a remainder of " + rem1 + "."); //print statement of remainder.
                System.out.println("Returning to selection module");
                System.out.println("");

            } else if (programSelection == 3) {
                System.out.println("Thanks for selecting program 3");
                ArrayList<String> strInputs = new ArrayList<String>(); //initializing the empty array list.
                Scanner in = new Scanner(System.in); //adding an input for the array list
                String cont = "y";

                do {
                    System.out.println("Please enter a word to add to the array list.");
                    String nextInput = in.next();
                    strInputs.add(nextInput);
                    System.out.println(strInputs);
                    System.out.println("continue? (type 'y' and hit enter to continue, otherwise type something else)");
                    cont = in.next();

                } while (cont.equals("y"));
                System.out.println("Array List before sort.");
                System.out.println(strInputs);
                Collections.sort(strInputs); //sorting in alphabetical order
                System.out.println("Array List after sort.");
                System.out.println(strInputs);
                System.out.println("Returning to selection module");
                System.out.println("");

            } else if (programSelection == 4) {
                System.out.println("Thanks for selecting program 4");
                String path = System.getProperty("user.home"); //gets the users home directory
                System.out.println("The user directory is:" + path);
                File dir = new File(path); // creates a pathway for the file
                for (File f : dir.listFiles()) { //gets a list of files in the specified users home directory.
                    if (f.getName().contains("name.txt")) { //limits to files with name of what we are looking for
                        System.out.println(f.getName());
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(path + "/name.txt"));
                            String s;
                            while ((s = br.readLine()) != null) {
                                System.out.println("Hello, "+ s + "!");
                                break;
                            }
                            br.close();
                        } catch (Exception ex) {
                            return;
                        }
                    }
                }
                //when it is all done we still want the user to input their name and overwrite the file 
                try {
                    BufferedWriter bw = new BufferedWriter(
                            new FileWriter(path + "/name.txt")); // not sure if this is right
                    System.out.println("Please Write your name to be written to file:");
                    bw.write(sc.next()); // takes user input and assigns it to buffered writer and writes it to specified pathway
                    bw.close();
                } catch (Exception ex) {
                    return;
                }

                System.out.println("Returning to selection module");
                System.out.println("");

            } else if (programSelection == 5) {
                System.out.println("Thanks for selecting program 5.");
                System.out.println("The program will now end.");
                System.exit(0);

            } else {
                System.out.println("Please make a valid selection");
                System.out.println("Returning to selection module");
                System.out.println("");

            }
        }
    }
}
