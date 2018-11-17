import org.junit.Assert;
import org.junit.Test;

public class JosnFormatTest {

    @Test
    public void testOneRecord() {

        Vehicle BlueBMW = new Vehicle("Blue X3 2017", VehicleType.SUV);
        Rental x3Rental = new Rental(BlueBMW, 240, 5, false);

        Customer sharmDreams = new Customer("Sharm Dreams");

        sharmDreams.addRental(x3Rental);

        StatmentService statmentService = new StatmentService(sharmDreams);

        Assert.assertEquals("{\n" +
                "\t\"customer\" : \"Sharm Dreams\",\n" +
                "\t\"records\" = [\n" +
                "\t\t{\n" +
                "\t\t\t\"model\" : \"Blue X3 2017\",\n" +
                "\t\t\t\"amount\" : 760.0\n" +
                "\t\t}],\n" +
                "\t\"total\" : 760.0,\n" +
                "\t\"Reward Points\" : 1\n" +
                "}",statmentService.getJsonStatment());

    }

    @Test
    public void testMoreRecords() {

        Vehicle blueHonda = new Vehicle("Blue Honda 2008", VehicleType.SEDAN);
        Vehicle greyJeep = new Vehicle("Grey Jeep 2013", VehicleType.FOURxFOUR);
        Vehicle RedSunny = new Vehicle("Red Sunny 2014", VehicleType.SEDAN);


        Rental hondaRental = new Rental(blueHonda, 431, 4, false);
        Rental jeepRental = new Rental(greyJeep, 744, 4, false);
        Rental sunnnyRental = new Rental(RedSunny, 591, 3, true);

        Customer virginGates = new Customer("Virgin Gates");


        virginGates.addRental(hondaRental);
        virginGates.addRental(jeepRental);
        virginGates.addRental(sunnnyRental);

        StatmentService statmentService = new StatmentService(virginGates);
        Assert.assertEquals("{\n" +
                "\t\"customer\" : \"Virgin Gates\",\n" +
                "\t\"records\" = [\n" +
                "\t\t{\n" +
                "\t\t\t\"model\" : \"Blue Honda 2008\",\n" +
                "\t\t\t\"amount\" : 912.0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"model\" : \"Grey Jeep 2013\",\n" +
                "\t\t\t\"amount\" : 850.0\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"model\" : \"Red Sunny 2014\",\n" +
                "\t\t\t\"amount\" : 1268.96\n" +
                "\t\t}],\n" +
                "\t\"total\" : 3030.96,\n" +
                "\t\"Reward Points\" : 4\n" +
                "}",statmentService.getJsonStatment());



    }
}
