public class Rental {

    private Vehicle vehicle;
    private int kilometersRented;
    private int daysRented;
    private boolean lateFee;

    public Rental(Vehicle vehicle, int mileage,int daysRented,boolean lateFee) {
        this.vehicle = vehicle;
        this.kilometersRented = mileage;
        this.daysRented=daysRented;
        this.lateFee=lateFee;
    }

    public int getKilometersRented() {
        return kilometersRented;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public boolean isLateFee() {
        return lateFee;
    }
}
