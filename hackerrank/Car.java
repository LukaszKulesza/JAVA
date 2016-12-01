
package pl.codeme.hackerrank;

public class Car {

	static int maxspeed = 100;
	static int minspeed = 0;
	static double weight = 4.09;
	static boolean IsTheCarOn = false;
	static char condition = 'A';
	
	double maxfuel=16;
	double currentfuel=8;
double mpg=76.43;

int maxPeopleInTheCar=4;

	public Car(int CarMinSpeed){
		minspeed=CarMinSpeed;
		
	}
	
	public static void wypisz() {
		System.out.println("maximum speed is "+maxspeed);
		System.out.println(minspeed);
		System.out.println(weight);
		System.out.println(IsTheCarOn);
		System.out.println(condition);

	}

	public void uprgadeMinSpeed(){
		minspeed=maxspeed;
		minspeed=minspeed+10;
	}
	
	
	
	
	public void wreckCar() {
		condition = 'C';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Car birthdayPresent=new Car(20);
		
	}

}
