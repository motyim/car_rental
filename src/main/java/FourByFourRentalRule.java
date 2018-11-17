/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class FourByFourRentalRule implements Rule {

    public boolean match(Rental rental) {
        return VehicleType.FOURxFOUR == rental.getVehicle().getVehicleType() ;
    }

    public Record calculate(Rental rental, Record record) {

        double amount  = record.getAmount();
        int points = record.getPoint();

        amount += 200 * rental.getDaysRented();

        if (hasDiscount(rental)) {
            amount -= amount * 0.05;
        }

        if(rental.isLateFee()){
            amount+=amount*0.03;
        }else{
            points = ++points * 2;
        }

        record.setPoint(points);
        record.setAmount(amount);

        return  record;
    }

    private boolean hasDiscount(Rental rental) {
        return rental.getKilometersRented() >= 200 && rental.getDaysRented() > 10;
    }

}
