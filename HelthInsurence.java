import java.lang.Math;
import java.util.Scanner;

public class HelthInsurence{
	public final long basePremium = 5000;
	public double agePremium(int age){
		double premium=basePremium;
		if(age>=18){
			premium = (premium * 10/100) + premium;
		}
		int i=25;
		while(i<=age){					
			if(age>=40){
				premium = (premium * 20/100) + premium;
			}else{
				premium = (premium * 10/100) + premium;
			}
			i+=5;
		}
		return premium;
	}
	public double genderPremium(double premium, String gender){
		if(gender.equalsIgnoreCase("male")){
			return ((premium * 2/100) + premium);
		}
		return premium;
	}
	public double helthConPremium(double premium, int helthCon){
		return (premium + (premium * helthCon/100));
	}
	public double habitPremium(double premium, int goodHabit, int badHabbit){
		return (premium + (premium * (goodHabit-badHabbit)/100));
	}
		
	public long calculatePremiumAmount(int age, String gender, int helthCon, int goodHabit, int badHabbit){
			return Math.round(this.habitPremium(this.helthConPremium(this.genderPremium(this.agePremium(age) , gender) , helthCon) ,goodHabit, badHabbit));
	}
	public static void main(String deb[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("your Name: ");
		String name=sc.nextLine();
		System.out.println("your Gender: ");
		String gen=sc.nextLine();
		System.out.println("your Age: ");
		int age=sc.nextInt();
		System.out.println("provide current helth condition in yes/no");
		System.out.println("   Do you have hypertension: ");
		sc.nextLine();
		String hpt=sc.nextLine();
		System.out.println("   Do you have Blood pressure: ");
		String bp=sc.nextLine();
		System.out.println("   Do you have Blood sugar: ");
		String bs=sc.nextLine();
		System.out.println("   Do you have Overweight: ");
		String ow=sc.nextLine();
		System.out.println("provide your Habits in yes/no");
		System.out.println("  you have smoking habit: ");
		String sh=sc.nextLine();
		System.out.println("  you have alcohol habit: ");
		String ah=sc.nextLine();
		System.out.println("  you exercise daily: ");
		String ed=sc.nextLine();
		System.out.println("  you use to take drugs: ");
		String d=sc.nextLine();
		int hc=0;
		if(hpt.equalsIgnoreCase("yes"))hc++;
		if(bp.equalsIgnoreCase("yes"))hc++;
		if(bs.equalsIgnoreCase("yes"))hc++;
		if(ow.equalsIgnoreCase("yes"))hc++;
		int bh=0;
		if(sh.equalsIgnoreCase("yes"))bh++;
		if(ah.equalsIgnoreCase("yes"))bh++;
		if(d.equalsIgnoreCase("yes"))bh++;
		int gh=0;
		if(ed.equalsIgnoreCase("yes"))gh++;
		HelthInsurence hi=new HelthInsurence();
		String sn=(gen.equalsIgnoreCase("male"))? "Mr" : "Mrs";
		System.out.println("Health Insurance Premium for "+sn+". "+name+": Rs."+ hi.calculatePremiumAmount(age,gen,hc,bh,gh));
	}
}