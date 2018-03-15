package TaxCal;

public class TaxFormula {
	
	public TaxFormula(){}
	
	private double MPFdedcution(int total_income){
		if(total_income*0.05>=15000)
			return total_income-15000;
		else
			return total_income*0.95;
	}
	
	private double Dedcution_allowence(double income_after_MPFdedcution){
		if(income_after_MPFdedcution>=132000)
			return income_after_MPFdedcution-132000;
		else
			return 0;
	}
	
	private double Joint_Dedcution_allowence(double income_after_MPFdedcution){
		if(income_after_MPFdedcution>=264000)
			return income_after_MPFdedcution-264000;
		else
			return 0;
	}
	
	private double tax_cal(double income_after_DA){
		if(income_after_DA>=135000)
			return (income_after_DA-135000)*0.17+9450;
		else if(income_after_DA>=90000)
			return (income_after_DA-90000)*0.12+4050;
		else if(income_after_DA>=45000)
			return (income_after_DA-45000)*0.07+900;
		else 
			return income_after_DA*0.02;
	}
	
	
	private double tax_payable(double tax){
		if(tax*0.75>20000)
			return tax-20000;
		else 
			return tax-tax*0.75;
	}
	
	public double single_case(int total_income){
		
		double income_after_MPFdedcution = MPFdedcution(total_income);
		double income_after_DA = Dedcution_allowence(income_after_MPFdedcution);
		double tax = tax_cal(income_after_DA);
		double final_tax = tax_payable(tax);
		
		return final_tax;
	}
	
	public double joint_case(int total_income1,int total_income2){
		
		double income_after_MPFdedcution1 = MPFdedcution(total_income1);
		//System.out.println(income_after_MPFdedcution1);
		double income_after_MPFdedcution2 = MPFdedcution(total_income2);
		//System.out.println(income_after_MPFdedcution2);
		
		double income_after_DA1 = Dedcution_allowence(income_after_MPFdedcution1);
		//System.out.println(income_after_DA1);
		double income_after_DA2 = Dedcution_allowence(income_after_MPFdedcution2);
		//System.out.println(income_after_DA2);
		double total_income_after_DA = Joint_Dedcution_allowence(income_after_MPFdedcution1+income_after_MPFdedcution2);
		
		double tax_cal1 = tax_cal(income_after_DA1);
		//System.out.println(tax_cal1);
		double tax_cal2 = tax_cal(income_after_DA2);
		//System.out.println(tax_cal2);
		double joint_tax_cal = tax_cal(total_income_after_DA);
		
		if(tax_payable(joint_tax_cal)<tax_payable(tax_cal1)+tax_payable(tax_cal2)){
			System.out.println("Joint Assessment is recommended.");
			return tax_payable(joint_tax_cal);
		}
		else{
			System.out.println("Joint Assessment is not recommended.");
			//System.out.println(tax_payable(tax_cal1));
			//System.out.println(tax_payable(tax_cal2));
			return tax_payable(tax_cal1)+tax_payable(tax_cal2);
		}
}

}
