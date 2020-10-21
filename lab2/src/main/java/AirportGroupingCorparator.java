import org.apache.hadoop.io.WritableComparator;

public class AirportGroupingCorparator extends WritableComparator {
    @Override
    public int compare(FlightsWritableComparable a, FlightsWritableComparable b){
        return a.compareTo(b);
    }
}
