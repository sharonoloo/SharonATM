package atmPackage;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSharonATM {

	ATM newTest = mock(ATM.class);

	float balance = 0;
	float input = 500;
	float withdrawal;
	String value;
	/*
	 * @BeforeTest public static void anotherTransaction(){
	 * System.out.println("Type 'MENU' and press enter to go back to main menu"
	 * ); String value = "menu"; if(value.equalsIgnoreCase("menu")){
	 * 
	 * ATM.transaction(); } }
	 */

	@Test(priority = 1, dataProvider = "getDepositData")
	public void testDeposit(float deposit) {

		int count = 1;

		if (count <= 4) {
			System.out.println("DEPOSIT: ");
			System.out.println("Current Balance: " + balance);

			if (deposit <= 0)
				System.out.println("Only deposit values greater than zero are accepted");
			else if (deposit > 40000) {
				System.out.println("Max Deposit amount of 40000 per transaction surpassed");
				doNothing().when(newTest).transaction();
				return;
			} else {

				if (balance < 150000) {
					// update balance
					balance = deposit + balance;
					System.out.println("You have deposited " + deposit + " new balance is " + balance + "\n");

				} else
					System.out.println("Max Deposit amount of 150000 per day surpassed");

			}
			
			count++;
		} else
		 System.out.println("Max Deposit Frequency surpassed");

	}

	@Test(priority = 2, dataProvider = "getWithdrawData")
	public void testWithdraw(float amount) {
		int count1 = 1;

		if (count1 <= 3) {

			System.out.println("\n" + "WITHDRAWAL: ");
			System.out.println("Current Balance: " + balance);
			// check if they have enough money to withdraw
			if (amount > balance || amount == 0) {
				System.out.println("You have insufficient funds\n\n");

				// anotherTransaction();
			} else {
				// check the transaction amount does not exceed 20k
				if (amount > 20000) {
					System.out.println("Max Withdrawal cannot exceed 20000 per transaction");
					return;
					// Max withdrawal per transaction =20k
					// anotherTransaction();
				} else {
					withdrawal = withdrawal + amount;
					// check total withdrawn amount does not exceed 50000
					if (withdrawal > 50000) {
						System.out.println("Max Withdrawal cannot exceed 50000 per day");
						return;
						// anotherTransaction();
					}
				}
				// deduct the withdrawn amount from the account balance
				balance = balance - amount;
				System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
				// ++count1;

				doNothing().doThrow(new IllegalArgumentException()).when(newTest).anotherTransaction();
				// newTest.anotherTransaction();

				// does nothing the first time:
				// newTest.anotherTransaction();

			}

		} else
			System.out.println("Max Withdrawal Frequency surpassed");

	}

	@Test(priority = 0)
	public void testBalance() {
		System.out.println("BALANCE \n" + balance + "\n");

	}

	@Test(priority = 3)
	public void testQuit() {
		System.out.print("Are you sure you want to quit? 'YES' or 'NO'\n");
		String value = "yes";
		if (value.equalsIgnoreCase("yes")) {
			System.out.println("Goodbye");
			
		} else {
			System.exit(0);
			
		}
	}
	

	@DataProvider
	public Object[][] getDepositData() {
		Object[][] data = new Object[8][1];
		data[0][0] = 0;
		data[1][0] = 50000;
		data[2][0] = 40000;
		data[3][0] = 40000;
		data[4][0] = 30000;
		data[5][0] = 31000;
		data[6][0] = 9000;
		data[7][0] = 15000;

		return data;
	}

	@DataProvider
	public Object[][] getWithdrawData() {
		Object[][] data = new Object[5][1];
		data[0][0] = 5000000;
		data[1][0] = 21000;
		data[2][0] = 15000;
		data[3][0] = 19000;
		data[4][0] = 18000;
		return data;

	}
}
