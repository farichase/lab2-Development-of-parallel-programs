package airports;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportsPartitioner extends Partitioner<FlightsWritableComparable, Text> {
    @Override
    public int getPartition(FlightsWritableComparable key, Text value, int numReduceTasks){
        return (key.getAeroport_id() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
