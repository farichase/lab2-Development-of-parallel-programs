import org.apache.hadoop.io.RawComparator;

public class AirportGroupingCorparator implements RawComparator {

    public int compare(FlightsWritableComparable a, FlightsWritableComparable b){
        return a.compareTo(b);
    }
}
