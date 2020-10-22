import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.util.Iterator;

public class AirportsReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    @Override
    protected void reduce(FlightsWritableComparable key, Iterable<Text> values, Context context){
        Iterator<Text> iter = values.iterator();
        while (iter.hasNext()) {

        }
    }
}
