/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class JsonFormat implements Format {

    @Override
    public String print(Statment statment) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n\t\"customer\" : \"");
        builder.append(statment.getCustomeName());
        builder.append("\",\n\t\"records\" = [");


        for (int i = 0; i < statment.getRecords().size() ; i++) {

            builder.append("\n\t\t");


            builder.append(print(statment.getRecords().get(i)));

            if( i != statment.getRecords().size()-1 )
                builder.append(",");
        }

        builder.append("],\n\t\"total\" : ");
        builder.append(statment.getTotalAmount());
        builder.append(",\n\t\"Reward Points\" : ");
        builder.append(statment.getTotalPoint());
        builder.append("\n}");

        return builder.toString();
    }

    @Override
    public String print(Record record) {
        return "{\n" +
                "\t\t\t\"model\" : \""+record.getVehicle().getMakeAndModel()+"\",\n" +
                "\t\t\t\"amount\" : "+record.getAmount()+"\n" +
                "\t\t}";
    }
}
