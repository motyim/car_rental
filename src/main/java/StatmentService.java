/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class StatmentService {

    private Customer customer ;
    private Statment statment ;
    private RuleEngine ruleEngine ;


    public StatmentService(Customer customer) {
        this.customer = customer;
        statment = new Statment();
        statment.setCustomeName(customer.getName());
        ruleEngine = new RuleEngine();
        statement();
    }

    private void statement() {

        ruleEngine.registerRule(new FourByFourRentalRule())
                .registerRule(new SedanRentalRule())
                .registerRule(new SuvRentalRule());


        for (Rental rental:customer.getRentals()) {
            // Setup fee, as decided by management in Dec 2016
            double thisAmount = 50;

            Record record = new Record(thisAmount,statment.getTotalPoint() , rental.getVehicle());
            record = ruleEngine.rule(rental,record);

            statment.addRecord(record);
            statment.setTotalPoint(record.getPoint());

            // show figures for this rental
            statment.setTotalAmount(statment.getTotalAmount() + record.getAmount());

        }

    }

    public String getTextStatment(){
        return new PlainTextFormat().print(statment);
    }

    public String getJsonStatment(){
        return new JsonFormat().print(statment);
    }
}
