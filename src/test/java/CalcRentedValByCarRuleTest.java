import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcRentedValByCarRuleTest {

    Rule rule ;

    @Before
    public void setUp() throws Exception {
        rule = new CalcRentedValByCarRule();

    }


    @Test
    public void testSedanWithNoExceedKiloRented(){
        Vehicle blueHonda = new Vehicle("Blue Honda 2008", Vehicle.SEDAN);
        Rental hondaRental = new Rental(blueHonda, 200, 4, false);

        assertEquals(450 , rule.calculate(hondaRental,50),0);
    }

    @Test
    public void testSedanWithExceedKiloRented(){
        Vehicle blueHonda = new Vehicle("Blue Honda 2008", Vehicle.SEDAN);
        Rental hondaRental = new Rental(blueHonda, 300, 4, false);

        assertEquals(650 , rule.calculate(hondaRental,50),0);
    }

    @Test
    public void testFourxFourRented(){
        Vehicle greyJeep = new Vehicle("Grey Jeep 2013", Vehicle.FOURxFOUR);
        Rental jeepRental = new Rental(greyJeep, 280, 4, false);

        Assert.assertEquals(850, rule.calculate(jeepRental , 50 ),0);
    }


    @Test
    public void testSuvWithNoExceedKiloRented(){
        Vehicle BlueBMW = new Vehicle("Blue X3 2017", Vehicle.SUV);
        Rental x3Rental = new Rental(BlueBMW, 280, 4, false);

        assertEquals(650 , rule.calculate(x3Rental,50),0);
    }


    @Test
    public void testSuvWithExceedKiloRented(){
        Vehicle BlueBMW = new Vehicle("Blue X3 2017", Vehicle.SUV);
        Rental x3Rental = new Rental(BlueBMW, 290, 4, false);

        assertEquals(670 , rule.calculate(x3Rental,50),0);
    }


    @Test
    public void testOtherRented(){
        Vehicle car = new Vehicle("Blue X3 2017", 4);
        Rental rental = new Rental(car, 290, 4, false);

        assertEquals(50 , rule.calculate(rental,50),0);
    }

}