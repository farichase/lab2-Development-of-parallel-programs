import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportGroupingCorparator extends WritableComparator {
    public AirportGroupingCorparator() {
        super(FlightsWritableComparable.class, true);
    }
    @Override
    public int compare(WritableComparable a, WritableComparable b){
        FlightsWritableComparable a1 = (FlightsWritableComparable) a;
        FlightsWritableComparable b1 = (FlightsWritableComparable) b;
        return a1.compareTo(b1);
    }
}
