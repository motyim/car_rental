import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FourByFourRentalRuleTest {

    private Rule rule ;
    private Vehicle vehicle ;
    private Record record ;

    @Before
    public void setUp() throws Exception {
        rule = new FourByFourRentalRule();
        vehicle = new Vehicle("Grey Jeep 2013", VehicleType.FOURxFOUR);
        record = new Record(50,0);
    }

    @Test
    public void testVehicleWithNoDiscount(){
        Rental jeepRental = new Rental(vehicle, 280, 4, false);
        Record resultRecord = rule.calculate(jeepRental , record );

        assertEquals(850,resultRecord.getAmount() ,0);
        assertEquals(2,resultRecord.getPoint());
    }

    @Test
    public void testVehicleWithNoDiscount2(){
        Rental jeepRental = new Rental(vehicle, 10, 11, false);
        Record resultRecord = rule.calculate(jeepRental , record );

        assertEquals(2250.0,resultRecord.getAmount() ,0);
        assertEquals(2,resultRecord.getPoint());
    }

    @Test
    public void testVehicleWithDiscount(){
        Rental jeepRental = new Rental(vehicle, 300, 20, false);
        Record resultRecord = rule.calculate(jeepRental , record );
        assertEquals(3847.5,resultRecord.getAmount() ,0);
        assertEquals(2,resultRecord.getPoint());
    }


    @Test
    public void testVehicleWithDiscountAndLateFee(){
        Rental jeepRental = new Rental(vehicle, 300, 20, true);
        Record resultRecord = rule.calculate(jeepRental , record );
        assertEquals(3962.925,resultRecord.getAmount() ,0);
        assertEquals(0,resultRecord.getPoint());
    }

}