/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class Record {

    private Vehicle vehicle;
    private double amount ;
    private int point ;


    public Record(double amount, int point) {
        this.amount = amount;
        this.point = point;
    }

    public Record(double amount, int point, Vehicle vehicle) {
        this.amount = amount;
        this.point = point;
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
