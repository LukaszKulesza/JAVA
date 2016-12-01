package Javaforbeginners;


class Vehicle{
	int passengers;
	int fuelcap;
	double lkm;
	
	
	
}



public class VehicleDemo {

	public static void main(String[] args) {

Vehicle minivan= new Vehicle();
int range;
minivan.passengers=7;
minivan.lkm=9.1;
minivan.fuelcap=65;
		
		range=(int) (minivan.fuelcap/minivan.lkm*100);
		System.out.println("minivan przewozi " + minivan.passengers
				+" osob na odleglosc"+ range+ "km");
		
		
	}

}
