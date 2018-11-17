import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public Vector getRentals() {
        return rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int rewardPoints = 0;
        Enumeration rentals = getRentals().elements();
        String result = "Rental Record for:" + getName() + "\n";

        List<Rule> rules = new ArrayList<Rule>();
        rules.add(new CalcRentedValByCarRule());

        while (rentals.hasMoreElements()) {
            // Setup fee, as decided by management in Dec 2016
            double thisAmount = 50;
            Rental each = (Rental) rentals.nextElement();

            for (Rule rule: rules) {
                thisAmount = rule.calculate(each , thisAmount);
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
