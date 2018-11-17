import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuvRentalRuleTest {

    private Rule rule ;
    private Vehicle vehicle ;
    private Record record;

    @Before
    public void setUp() throws Exception {
        rule = new SuvRentalRule();
        vehicle = new Vehicle("Blue X3 2017", VehicleType.SUV);
        record = new Record(50,0);
    }

    @Test
    public void testSuvWithNoExceedKiloRented(){
        Rental x3Rental = new Rental(vehicle, 180, 4, false);
        Record resultRecord = rule.calculate(x3Rental,record);
        assertEquals(650 , resultRecord.getAmount(),0);
        assertEquals(1 , resultRecord.getPoint());
    }

    @Test
    public void testSuvWithNoExceedKiloRentedAndRentedMoreThan5Days(){
        Rental x3Rental = new Rental(vehicle, 180, 7, false);
        Record resultRecord = rule.calculate(x3Rental,record);
        assertEquals(1100 , resultRecord.getAmount(),0);
        assertEquals(3 , resultRecord.getPoint());
    }


    @Test
    public void testSuvWithExceedKiloRented(){
        Rental x3Rental = new Rental(vehicle, 290, 4, false);
        Record resultRecord = rule.calculate(x3Rental,record);
        assertEquals(636.5 ,resultRecord.getAmount(),0);
        assertEquals(1 , resultRecord.getPoint());
    }

    @Test
    public void testSuvWithExceedKiloRentedAndLateFee(){
        Rental x3Rental = new Rental(vehicle, 290, 4, true);
        Record resultRecord = rule.calculate(x3Rental,record);
        assertEquals(655.595 ,resultRecord.getAmount() ,0);
        assertEquals(0 , resultRecord.getPoint());
    }

}