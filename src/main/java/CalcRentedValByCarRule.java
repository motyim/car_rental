/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/16/2018
 */
public class CalcRentedValByCarRule implements Rule {

    public double calculate(Rental rental , double amount) {

        switch (rental.getVehicle().getRateCode()) {

            case Vehicle.SEDAN:
                amount += 100*rental.getDaysRented();
                if (rental.getKilometersRented() > rental.getDaysRented()*50)
                {
                    amount += (rental.getKilometersRented() - rental.getDaysRented()*50) * 2;
                }

                return amount ;

            case Vehicle.FOURxFOUR:
                return amount + 200 * rental.getDaysRented();

            case Vehicle.SUV:
                amount += 150*rental.getDaysRented();
                if (rental.getKilometersRented() > rental.getDaysRented()*70)
                    amount += (rental.getKilometersRented() - rental.getDaysRented()*70) * 2;

                return amount ;
        }

        return amount;
    }
}
