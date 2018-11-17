import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SedanRentalRuleTest {

    private Rule rule ;
    private Vehicle vehicle ;
    private Record record;

    @Before
    public void setUp() throws Exception {
        rule = new SedanRentalRule();
        vehicle = new Vehicle("Blue Honda 2008", VehicleType.SEDAN);
        record = new Record(50,0);
    }

    @Test
    public void testSedanWithNoExceedKiloRented(){
        Rental hondaRental = new Rental(vehicle, 200, 4, false);
        Record resultRecord =rule.calculate(hondaRental,record);
        assertEquals(450 , resultRecord.getAmount(),0);
        assertEquals(1 , resultRecord.getPoint());
    }

    @Test
    public void testSedanWithExceedKiloRented(){
        Rental hondaRental = new Rental(vehicle, 300, 4, false);
        Record resultRecord = rule.calculate(hondaRental,record);
        assertEquals(650 ,resultRecord.getAmount(),0);
        assertEquals(1 , resultRecord.getPoint());
    }

    @Test
    public void testSedanWithExceedKiloRentedAndLateFee(){
        Rental hondaRental = new Rental(vehicle, 300, 4, true);
        Record resultRecord = rule.calculate(hondaRental,record);
        assertEquals(669.5 ,resultRecord.getAmount() ,0);
        assertEquals(0 , resultRecord.getPoint());
    }

}