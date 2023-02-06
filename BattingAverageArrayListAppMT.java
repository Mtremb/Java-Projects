/*
*Name: Max Tremblay
*Date: 11/3/22
*Filename: BattingAverageArrayListAppMT
*Purpose: To obtain the number of times at bat from user, create an array List to store results at bat, and calculate slug percent and batting average
*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class BattingAverageArrayListAppMT {
    
    //declare a scanner object for input
    private static Scanner sc = new Scanner(System.in);
   
    public static void main(String[] args) {
        
        //display welcome message and declare variables
        System.out.println("Weclome to the Batting Average Calculator.");
        System.out.println("");
        
        String choice = "Y";
        
        //initiate while loop to do all calculations based on user input
        while (choice.equalsIgnoreCase("y")){
            
       // int i = 0;
        int sum = 0;
        int successfulAtBat = 0;
        
            //create the array list, then using for loop, populate array list, get the results at bat and successful hits and total bases
            int timesAtBat = getInt("Enter number of times at bat: ", 0, 11);
            
            System.out.println("");
            System.out.println(" 0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
            System.out.println("");
            
            ArrayList<Integer> results = new ArrayList<>();
         
            for (int i = 0; i < timesAtBat; i++) {
                
               int result;
               result = getInt("Result for at-bat " + (i + 1) + ": ", -1, 5 );
               results.add(result);
               
               sum += result;
               
               if ( result > 0){
                 successfulAtBat++;
               }
            }
            
            //create format object to format the results to 3 decimal places. display results, and ask if user wants to enter another
            DecimalFormat  batFormat;
            batFormat = new DecimalFormat("#,##0.000");
            double batAverage = (double)successfulAtBat / timesAtBat;
            double slugPercent = (double)sum / timesAtBat;
            
            System.out.println("");
            System.out.println("Batting Average: " + batFormat.format(batAverage));
            System.out.println("");
            System.out.println("Slugging Percent: " + batFormat.format(slugPercent));
            System.out.println("");
            
            choice = getChoiceString(sc, "Another batter? (y/n): ", "y", "n");
            System.out.println("");
        }
    }
    
    //method to validate integers
    public static int getInt(String prompt){
       int i = 0;
       boolean isValid = false;
       while (!isValid) {
           System.out.print(prompt);
           if (sc.hasNextInt()){
               i = sc.nextInt();
               isValid = true;
           } else {
               System.out.println("Error, please enter an integer.");
               System.out.println("");
           }
           sc.nextLine();
       }
       return i;
   }
   
   //method to validate integers
    public static int getInt(String prompt, int min, int max) {
       int i = 0;
       boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error, Number must be greater than " + min + ".");
                System.out.println("");
            } else if (i >= max) {
                System.out.println(
                        "Error, Number must be less than " + max + ".");
                System.out.println("");
            } else {
                isValid = true;
            }
        }
        return i;
   }
   
   //method to validate the choice string
    private static String getChoiceString(Scanner sc, String prompt, String s1, String s2) {
           
            String s = "";
            boolean isValid = false;
            
            while (!isValid){
                
               s = getRequiredString(sc, prompt);
               
               if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2))
                    System.out.println("Error, Please use a valid answer. (y/n)");
               else 
                   isValid = true;  
            }
           return s;
        }
        
        //validate that the input is in fact a string
    private static String getRequiredString(Scanner sc, String prompt) {
            
        String s = "";
        boolean isValid = false;
        
        while(!isValid){
            System.out.print(prompt);
            s = sc.nextLine();
            
            if(s.equals(""))
                System.out.println("Error, Please enter a valid choice. (y/n)");
            else
                isValid = true;     
        }
        return s;
    }
}
