import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.util.Iterator;

public class AirportsReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    int MAX = 0;
    int MIN = Integer.MAX_VALUE;
    @Override
    protected void reduce(FlightsWritableComparable key, Iterable<Text> values, Context context){
        Iterator<Text> iter = values.iterator();
        Text airport_name = iter.next();;
        if (iter.hasNext()) {
            int quantity = 0;
            float sum_min = 0, sum_max = 0;
            while (iter.hasNext()){
                String delay_min_str = String.valueOf(iter.next());
                float delay_min = Float.parseFloat(delay_min_str);
                ++quantity_min;
                sum += delay;
            }
        }
        context.write(new Text(airport_name), new LongWritable());
    }
}
