public class Vehicle {

    private final String makeAndModel;
    private final VehicleType vehicleType;

    public Vehicle(String makeAndModel, VehicleType vehicleType ) {
        this.makeAndModel = makeAndModel;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }
}
