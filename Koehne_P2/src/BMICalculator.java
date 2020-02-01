import java.util.Scanner;

//Thomas Koehne 1/28/20

public class BMICalculator {
	Scanner in = new Scanner(System.in);
	
	private double weight;
	private double height;
	private double Bmi;
	private String BmiCategory = new String();
	private int unitType;
	
	//Start by getting the input data
	public void readUserData() {
		readUnitType();
		readMeasurementdata();
	}
	
	//Calculates BMI based on unit type
	public void calculateBmi() {
		if(unitType == 1) {
			Bmi = (703 * getWeight()) / (getHeight() * getHeight());
		} else {
			Bmi = (getWeight()) / (getHeight() * getHeight());
		}
		calculateBmiCategory();
	}
	
	public void displayBmi() {
		System.out.printf("Your BMI is: %.1f\nYour BMI Category is: %s", getBmi(), getBmiCategory());
	}
	
	//Ask for the user to choose a unit type
	//The while loop ensures a valid unit is chosen
	private void readUnitType() {
		while (unitType != 1 && unitType != 2) {
			System.out.println("Choose a Unit:");
			System.out.println("1. Imperial");
			System.out.println("2. Metric");
			unitType = in.nextInt();
			if(unitType != 1 && unitType != 2) {
				System.out.println("Must Choose 1 or 2!");
			}
		}	
	}
	
	//Determines which method to use based on unit type
	private void readMeasurementdata() {
		if (unitType == 1) {
			readImperialData();
		} else {
			readMetricData();
		}
	}
	
	//Ask for user data in Imperial
	private void readImperialData() {
		System.out.print("Enter Your Height in Inches: ");
		setHeight(in.nextDouble());
		System.out.print("Enter Your Weight in Pounds: ");
		setWeight(in.nextDouble());
	}
	
	//Ask for user data in Metric
	private void readMetricData() {
		System.out.print("Enter Your Height in Meters: ");
		setHeight(in.nextDouble());
		System.out.print("Enter Your Weight in Kilograms: ");
		setWeight(in.nextDouble());
	}

	//Calculates Bmi Category based on BMI
	private void calculateBmiCategory() {
		if (Bmi < 18.5) {
			BmiCategory = "Underweight";
		} if(Bmi >= 18.5 && Bmi < 25) {
			BmiCategory = "Normal";
		} if(Bmi >= 25 && Bmi < 30) {
			BmiCategory = "Overweight";
		} if(Bmi >= 30 ){
			BmiCategory = "Obese";
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	//Sets weight and makes sure the user input is greater than 0
	private void setWeight(double weight) {
		if(weight > 0) {
			this.weight = weight;
		} else {
			System.out.println("Weight Can Not Be Negative! \nExiting Program.");
			System.exit(0);
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	//Sets weight and makes sure the user input is greater than 0
	private void setHeight(double height) {
		if(height > 0) {
			this.height = height;
		} else {
			System.out.println("Height Can Not Be Negative! \nExiting Program.");
			System.exit(0);
		}
		
	}
	
	public double getBmi() {
		return Bmi;
	}
	
	public String getBmiCategory() {
		return BmiCategory;
	}
	
}