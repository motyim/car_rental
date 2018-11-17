/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class PlainTextFormat implements Format {


    @Override
    public String print(Statment statment) {
        StringBuilder result  = new StringBuilder();
        result.append("Rental Record for:" + statment.getCustomeName() + "\n");
        for (Record record : statment.getRecords()) {
            result.append(print(record));
        }
        result.append("Amount owed is LE " + String.valueOf(statment.getTotalAmount()) + "\n");
        result.append("You earned: " + String.valueOf(statment.getTotalPoint()) +
                " new Reward Points\n\n");


        return result.toString();
    }

    @Override
    public String print(Record record) {
        return "\t\"" + record.getVehicle().getMakeAndModel() + "\"\tLE " + String.valueOf(record.getAmount()) + "\n";
    }

}
