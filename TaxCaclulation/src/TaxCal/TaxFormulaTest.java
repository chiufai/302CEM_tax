package TaxCal;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Scanner;

public class TaxFormulaTest {

	@Test
	public void test() {
		TaxFormula taxCalculate; 
		taxCalculate = new TaxFormula();
		Scanner scanner = new Scanner(System.in);
		
		
		int single_or_joint;
		do{
			System.out.print("Single or joint case?(1:Single/2:Joint): ");
			single_or_joint = scanner.nextInt();
			if(single_or_joint!=1 && single_or_joint!=2)
				System.out.println("Invaild input, please try again.");
		}while(single_or_joint!=1 && single_or_joint!=2);
		
		double final_tax;
		if(single_or_joint==1){
			int income;
			System.out.print("Please input the total income: ");
			income = scanner.nextInt();
			final_tax = taxCalculate.single_case(income);
			System.out.printf("The final tax is $%.2f",final_tax);
		}
		else if(single_or_joint==2){
				int income1,income2;
				System.out.print("Please input the total income of the first person: ");
				income1 = scanner.nextInt();
				System.out.print("Please input the total income of the second person: ");
				income2 = scanner.nextInt();
				final_tax = taxCalculate.joint_case(income1,income2);
				System.out.printf("The final tax is $%.2f",final_tax);
			}
	}

}
