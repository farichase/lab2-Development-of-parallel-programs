import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.util.Iterator;

public class AirportsReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    @Override
    protected void reduce(FlightsWritableComparable key, Iterable<Text> values, Context context){
        Iterator<Text> iter = values.iterator();
        Text airport_name = iter.next();;
        if (iter.hasNext()) {
            int quantity = 0;
            float sum = 0;
            while (iter.hasNext()){
                String delay_str = String.valueOf(iter.next());
                float delay = Float.parseFloat(delay_str);
                ++quantity;
                sum += delay;
            }
        }
        context.write(new Text(airport_name), new LongWritable());
    }
}
