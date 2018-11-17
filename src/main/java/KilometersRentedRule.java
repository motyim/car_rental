/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/16/2018
 */
public class KilometersRentedRule implements Rule {

    public double calculate(Rental rental, double amount) {

        if (!(rental.getKilometersRented() <200)) {
            if (rental.getDaysRented() > 10 && rental.getVehicle().getRateCode() == Vehicle.FOURxFOUR) {
                amount -= amount * 0.05;
            } else if (rental.getVehicle().getRateCode() == Vehicle.SUV) {
                amount -= amount * 0.05;
            }
        }
        return amount ;
    }

}
