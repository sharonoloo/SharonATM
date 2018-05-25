package atmPackage;

import java.util.Scanner;

public class ATMMain {
	 	private static Scanner input;
	 	static int choice;
	 	static int count = 1;
	 	static int count1 = 1;
	 	private static float withdrawal;
	    private static float balance = 0; // initial balance to 0 for everyone
	   
	    public static void main(String args[]){
	        input = new Scanner(System.in);
	        // call our transaction method here 
	       transaction();
	    }
	 
	    public static  void transaction(){
	    	 
	 
	        //menu options 
	        System.out.println("1. Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Quit");
	        System.out.println("\n\nEnter Menu Option"); 
	        System.out.println(">"); 
	        System.out.println("*********************************************************************"); 
	 
	        choice = input.nextInt();
	 
	        switch(choice){
	            case 1:
	            	// this option is to check balance 
	                System.out.println("BALANCE \n"+balance+"\n");
	                anotherTransaction(); 
	            break;
	 
	            default:
	                System.out.println("Invalid option:\n\n"); 
	                transaction();
	            break;
	               
	 
	            case 2:
	                // option number 2 is depositing 
	            	 
	            	while (count <= 4) 
	            	{
		                float deposit; 
			           
		                System.out.println("DEPOSIT: ");
		                System.out.println("Current Balance: " + balance); 
		               
		                deposit = input.nextFloat();
		                if(deposit<=0)
		                {
		                	System.out.println("Only deposit values greater than zero are accepted");
		                }
		                else{
		                if(deposit>40000)
		                {
		                	System.out.println("Max Deposit amount of 40000 per transaction surpassed");
		                	transaction();
		                }
		               
		                // update balance 
		                balance = deposit + balance;
		                if(balance>150000)
		                {
		                	System.out.println("Max Deposit amount of 150000 per day surpassed");
		                }
		                else
		                {
			                System.out.println("You have deposited "+deposit+" new balance is "+balance+"\n");
			                ++count;
		                }
		                anotherTransaction();
		               
		                }}
	            
	            	System.out.println("Max Deposit Frequency surpassed");
	            	
	            break; 
	            case 3:
	            	//this option is to withdraw
	            	while(count1<=3)
	            	{
		            	float amount;
			            System.out.println("WITHDRAWAL: ");
			            System.out.println("Current Balance: " + balance);
			            amount = input.nextFloat();
			            //check if they have enough money to withdraw
			            if(amount > balance || amount == 0)
			            {
			                    System.out.println("You have insufficient funds\n\n"); 
			                    anotherTransaction(); 
			             } else 
			                {
			            	 	//check the transaction amount does not exceed 20k
			                    if(amount>20000 )
				                {
				                	System.out.println("Max Withdrawal cannot exceed 20000 per transaction");
				                	//Max withdrawal per transaction =20k
				                	anotherTransaction();
				                }
			                    withdrawal=withdrawal+amount;
			                    //check total withdrawn amount does not exceed 50000
			                    if(withdrawal>50000)
			                    {
			                    	System.out.println("Max Withdrawal cannot exceed 50000 per day");
			                    	anotherTransaction();
			                    }
			                    //deduct the withdrawn amount from the account balance
			                    balance = balance - amount; 
			                    System.out.println("You have withdrawn "+amount+" and your new balance is "+balance+"\n");
			                    ++count1;
			                    anotherTransaction(); 
			                }
	            	}
	            	System.out.println("Max Withdrawal Frequency surpassed");
		            break; 
	            case 4:
	            	//this option is to quit
	            	System.out.print("Are you sure you want to quit? 'YES' or 'NO'\n");
	            	String value = input.next();
	 	            if(value.equalsIgnoreCase("yes"))
	 	            {
	 	            	System.out.println("Goodbye");
	 	            	System.exit(0);
	 	            }else
	 	            {
	 	            	transaction();
	 	            }
	 	            
	                
	        }
	 
	    }
	 
	    public static void anotherTransaction(){
	    	   System.out.println("Type 'MENU' and press enter to go back to main menu");
	    	   String value = input.next();
	           if(value.equalsIgnoreCase("menu")){
	        	   transaction();
	    	   
	        }
	    }
	    
	}
