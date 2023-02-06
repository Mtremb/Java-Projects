/*
*Name: Max Tremblay
*Date: 10/3/22
*Filename: InvoiceAppMT
*Purpose: To obtain an invoice amount from user and calculate total based on entered information
*/


import java.util.Scanner; 



public class InvoiceApp { 

    public static void main(String[] args) { 

        // TODO code application logic here 
        System.out.println("Welcome to the Invoice Total Calculator\n"); 

        //construct object 
        Scanner sc = new Scanner(System.in); 

        //set up loop to perform calculations as long as user chooses y 
        String choice = "y"; 

        while(choice.equalsIgnoreCase("y")) { 

            //get the subtotal from the user 
            //prompt the user and then read in value 
            System.out.println("Enter Subtotal:\t\t"); 

            double subtotal = sc.nextDouble(); 

            //determine discount percent based on subtotal 
            double discountPercent = 0; 

            if(subtotal>= 200) 

                discountPercent = .2; 

            else if(subtotal >= 100) 

                discountPercent = .1; 

            else 
            	
            	discountPercent = 0; 

            //calculate the discount and total 
            double discountAmount = subtotal discountPercent; 

            double total = subtotal - discountAmount; 


            //create a string to store the output 
            String message = "Discount Percent:\t" + discountPercent 

                    + "\nDiscount Amount:\t" + discountAmount

                    +"\nInvoice Total:\t\t" + total + "\n"; 

            //display the output message 
            System.out.println(message); 

            //see if user wants to continue 
            System.out.print("Continue? (y/n"); 

            choice = sc.next(); 

            System.out.println(""); 

        } 

    } 

}

