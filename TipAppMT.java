import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

/**Name: Max Tremblay
 * Date: 8/6/22
 * Filename: TipCalculator
 * Purpose: To accept input for the cost of a meal and calculate expected tip amounts for a receipt
 */
public class TipAppMT {
    
    public static void main(String[] args) {
        // Display welcome title and create scanner object
        System.out.println("Tip Calculator");
        System.out.println("");
        
        Scanner sc = new Scanner(System.in);
        
        //assign initial Y to choice and create BigDecimal to increment for loop
        String choice = "y";
        final BigDecimal PCT = new BigDecimal(0.05);
        
        //create formating objects and initialize while loop
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        
       while(choice.equalsIgnoreCase("y")) {
            
           //obtain input from user as BigDecimal
            System.out.print("Cost of Meal: ");
            BigDecimal mealCost = new BigDecimal(sc.nextDouble());
            
            //create for loop for the tip amounts and calculate/display accordingly
            for(BigDecimal tip = new BigDecimal(.15);tip.doubleValue() <= 0.25; tip = tip.add(PCT)){
               
                BigDecimal tipAmount = mealCost.multiply(tip);
                tipAmount.setScale(2, RoundingMode.HALF_UP);
                BigDecimal total = tipAmount.add(mealCost);
                
                String message = 
                        "RESULTS FOR "      + percent.format(tip) +
                        "\nTip Amount:\t"   + currency.format(tipAmount) +
                        "\nTotal Amount:\t" + currency.format(total);
                System.out.println(message);
                System.out.println("");
                }
            
            //see if user wants to continue and make sure it is a yes or no answer
            System.out.print("Continue? (y/n)");
            choice = sc.next();
            System.out.println("");
            
            if(choice.equalsIgnoreCase("n"))
                System.exit(0);
                else if(choice.equalsIgnoreCase("y")) 
                    continue;
                    else
                        System.out.print("Please enter either (y/n): ");
                        System.out.println("");
                        choice = sc.next();
            }
        }
   }
