public class Vehicle {
    // TODO: 11/16/2018 make enum
    public static final int SUV = 2;
    public static final int SEDAN = 0;
    public static final int FOURxFOUR = 1;

    private String makeAndModel;
    // TODO: 11/16/2018 Enum type
    private int rateCode;

    public Vehicle(String makeAndModel, int rateCode) {
        this.makeAndModel = makeAndModel;
        this.rateCode = rateCode;
    }

    public int getRateCode() {
        return rateCode;
    }

    public void setRateCode(int rateCode) {
        this.rateCode = rateCode;
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }
}
