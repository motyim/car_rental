/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class SuvRentalRule implements Rule {

    @Override
    public boolean match(Rental rental) {
        return VehicleType.SUV == rental.getVehicle().getVehicleType();
    }

    @Override
    public Record calculate(Rental rental, Record record) {

        double amount = record.getAmount();
        int points = record.getPoint();

        amount += 150*rental.getDaysRented();

        if (isExceedKilometersRented(rental))
            amount += (rental.getKilometersRented() - rental.getDaysRented()*70) * 2;


        if (hasDiscount(rental)) {
                amount -= amount * 0.05;
        }

        if(rental.isLateFee()){
            amount+=amount*0.03;
        }else{
            points++;
            if ( rental.getDaysRented() > 5)
                points += (rental.getDaysRented() - 5);
        }

        record.setPoint(points);
        record.setAmount(amount);
        return record;
    }

    private boolean isExceedKilometersRented(Rental rental) {
        return rental.getKilometersRented() > rental.getDaysRented()*70;
    }

    private boolean hasDiscount(Rental rental) {
        return rental.getKilometersRented() >= 200;
    }
}
