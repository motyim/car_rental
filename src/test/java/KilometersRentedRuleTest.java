import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KilometersRentedRuleTest {

    Rule rule ;

    @Before
    public void setUp() throws Exception {
        rule = new KilometersRentedRule();
    }

    @Test
    public void kilometersRentedLessThan200(){
        Vehicle blueHonda = new Vehicle("Blue Honda 2008", Vehicle.SEDAN);
        Rental hondaRental = new Rental(blueHonda, 100, 4, false);

        assertEquals(100 , rule.calculate(hondaRental,100),0);
    }


    @Test
    public void kilometersRentedEqualorGreaterThan200(){
        Vehicle blueHonda = new Vehicle("Blue Honda 2008", Vehicle.SEDAN);
        Rental hondaRental = new Rental(blueHonda, 200, 4, false);

        assertEquals(450 , rule.calculate(hondaRental,50),0);

    }


}