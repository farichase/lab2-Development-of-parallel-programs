import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportsPartitioner extends Partitioner<FlightsWritableComparable, Text> {
    public int getPartition(FlightsWritableComparable key, Text value, int numReduceTasks){
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
