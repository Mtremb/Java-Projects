/*Name: Max Tremblay
*Date: 9/17/22
*Filename: RectangleAppMT
*Purpose: To obtain user input for width and length, and validate answers, and calculate area and perimeter
*/
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class RectangleAppMT {

   
    public static void main(String[] args) {
        System.out.println("Welcome to the Area and Perimeter Calculator\n");
        
        //construct scanner object
        Scanner sc = new Scanner(System.in);
        
        //loop while choice is y or Y
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            //get inpout from user
            double length = getDoubleWithinRange(sc, "Enter length: ", 0, 1000);
            double width = getDoubleWithinRange(sc, "Enter width: ", 0, 1000);
            
            //calculate the area and perimeter
            double area = calculateArea(length, width);
            double perimeter = calculatePerimeter(length, width);
            
            //display formatted results
            displayResults(length, width, area, perimeter);
            
            //see if user wants to continue
            choice = getChoiceString(sc, "Continue? (y/n): ", "y", "n");
            System.out.println();
                        
        } //end while
        
    } //end main
    
        private static double getDouble(Scanner sc, String prompt) {
        //declare variable to store the user input
        double d = 0;
        //flag to get out of the loop
        boolean isValid = false;
        
        while(!isValid){
            // get input from the uer
            System.out.print(prompt);
            //before we read it in we need to make sure its proper type
            if(sc.hasNextDouble()){
                //if the input is correct read it in
                d = sc.nextDouble();
                        //if data is good, get out
                        isValid = true;
            }
            //what if the data isnt the correct type
            else {
                //display an error message
                System.out.println("Error! invalid type. please enter a decimal number.");   
            }
            //discard any other data on the line
            sc.nextLine();
        }
        //return the good data back to the calling method
        return d;
    }
       
        private static double getDoubleWithinRange(Scanner sc, String prompt,double min, double max){
            
        double d = 0;
        boolean isValid = false;
        
        while(!isValid) {
            
            //check to see if the number entered is within range and display error message if not
            d = getDouble(sc,prompt);
            if (d<= min)
                System.out.println("Error! Number must be greater than " + min + ".");
                        else if (d>= max)
                            System.out.println("Error! Number must be less than " + max + ".");
                        else
                            isValid = true;
        }
        return d;
    }
        
        private static double calculateArea(double length, double width) {
            
            //calculate area and return the value
            double area = length * width;
            return area;
        }
        
        private static double calculatePerimeter(double length, double width) {
            
            //calculate perimeter and return the value
            double perimeter = (2 * length) + (2 * width);
            return perimeter;
        }
        
        private static String getChoiceString(Scanner sc, String prompt, String s1, String s2) {
           
            //obtain string input from user, validate and return error message if needed
            String s = "";
            boolean isValid = false;
            
            while (!isValid){
                
               s = getRequiredString(sc, prompt);
               
               if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2))
                    System.out.println("Error! Please use a valid answer. (y/n)");
               else 
                   isValid = true;  
            }
           return s;
        }
        
        private static String getRequiredString(Scanner sc, String prompt) {
            //validate that the input is in fact a string
        String s = "";
        boolean isValid = false;
        
        while(!isValid){
            System.out.println(prompt);
            s = sc.nextLine();
            
            if(s.equals(""))
                System.out.println("Error! Please enter a valid choice. (y/n)");
            else
                isValid = true;
                
        }
        return s;
    }
        
        private static void displayResults(double length, double width, double area, double perimeter) {
            
          //display the formatted results
          NumberFormat df = new DecimalFormat("##.00");
            
            String message = "Area: " + df.format(area) + "\n" 
                           + "Perimeter: " + df.format(perimeter) + "\n"; 
            
             System.out.print(message);
        }
        
}
