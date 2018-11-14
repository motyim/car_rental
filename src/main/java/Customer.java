import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int rewardPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for:" + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line

//            if (each.getVehicle().getRateCode()==Vehicle.SEDAN || each.getVehicle().getRateCode()==Vehicle.SUV)
//            {
//                thisAmount=50*each.getDaysRented()+(each.getKilometersRented()-each.getDaysRented()*60)*2;
//            }
//            else
//            {
//                thisAmount=80*each.getDaysRented()+(each.getKilometersRented()-each.getDaysRented()*70)*3;
//            }

            // Setup fee, as decided by management in Dec 2016
            thisAmount=50.0;

            switch (each.getVehicle().getRateCode()) {

                case Vehicle.SEDAN:
                    thisAmount += 100*each.getDaysRented();
                    if (each.getKilometersRented() > each.getDaysRented()*50)
                    {
                        thisAmount += (each.getKilometersRented() - each.getDaysRented()*50) * 2;
                    }
                    break;


                case Vehicle.FOURxFOUR:
                    /* New Price applied
                    thisAmount += Double(190*each.getDaysRented())
                    */
                    thisAmount += 200*each.getDaysRented();
                    break;

                case Vehicle.SUV:
                    thisAmount += 150*each.getDaysRented();
                    if (each.getKilometersRented() > each.getDaysRented()*70)
                        thisAmount += (each.getKilometersRented() - each.getDaysRented()*70) * 2;
                    break;
                default:
                        thisAmount+=0;
            }

            // New rule of 2017, by john
            if (!(each.getKilometersRented() <200))
            {
                if (each.getDaysRented()>10 && each.getVehicle().getRateCode()== Vehicle.FOURxFOUR)
                {
                    thisAmount-=thisAmount*0.05;
                }
                else if (each.getVehicle().getRateCode()== Vehicle.SUV)
                {
                    thisAmount-=thisAmount*0.05;
                }
            }

            if (!each.isLateFee()) {
                // add frequent renter points
                rewardPoints++;

                // add bonus for SUV rental
                if ((each.getVehicle().getRateCode() == Vehicle.FOURxFOUR)) rewardPoints *= 2;

                // add bonus for SUV rental
                if ((each.getVehicle().getRateCode() == Vehicle.SUV) && each.getDaysRented() > 5)
                    rewardPoints += (each.getDaysRented() - 5);
            }
            else
            {
                // strict policy application as of Jan 2018
                thisAmount+=thisAmount*0.03;
            }
            // show figures for this rental
            result += "\t\"" + each.getVehicle().getMakeAndModel() + "\"\tLE " +
                    String.valueOf(thisAmount) + "\n";

            totalAmount+=thisAmount;

        }

        // add footer lines
        result += "Amount owed is LE " + String.valueOf(totalAmount) + "\n";

        result += "You earned: " + String.valueOf(rewardPoints) +
                " new Reward Points\n\n";
        return result;
    }
}
