/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class SedanRentalRule implements Rule {

    @Override
    public boolean match(Rental rental) {
        return VehicleType.SEDAN == rental.getVehicle().getVehicleType();
    }

    @Override
    public Record calculate(Rental rental, Record record) {

        double amount = record.getAmount();
        amount += 100*rental.getDaysRented();

        if (isExceedKilometersRented(rental))
        {
            amount += (rental.getKilometersRented() - rental.getDaysRented()*50) * 2;
        }

        if(rental.isLateFee()){
            amount+=amount*0.03;
        }else {
            record.setPoint(record.getPoint()+1);
        }

        record.setAmount(amount);

        return record ;

    }

    private boolean isExceedKilometersRented(Rental rental) {
        return rental.getKilometersRented() > rental.getDaysRented()*50;
    }
}
