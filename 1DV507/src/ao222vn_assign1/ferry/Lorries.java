package ao222vn_assign1.ferry;

public class Lorries extends Vehicle{
	
	public Lorries(int passenger) {
		super(passenger);
		super.sizeOfVehicle = 40;
		super.MAX_PASSENGERS = 2;
		super.PassengerCost = 15;
		super.vehicleCost = 300;
	}
	

}
