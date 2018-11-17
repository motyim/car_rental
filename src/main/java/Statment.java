import java.util.ArrayList;
import java.util.List;

/**
 * @author MA Motyim <mohamed.motyim@gmail.com>
 * @see <www.motyim.me>
 * @since 11/17/2018
 */
public class Statment {

    private String customeName ;
    private int totalPoint ;
    private double totalAmount ;
    private List<Record> records ;

    Statment(){
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }

    public String getCustomeName() {
        return customeName;
    }

    public void setCustomeName(String customeName) {
        this.customeName = customeName;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
