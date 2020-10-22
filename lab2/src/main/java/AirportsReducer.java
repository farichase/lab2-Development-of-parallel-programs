import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.util.Iterator;

public class AirportsReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    float MAX = 0.f;
    float MIN = Float.MAX_VALUE;
    @Override
    protected void reduce(FlightsWritableComparable key, Iterable<Text> values, Context context){
        Iterator<Text> iter = values.iterator();
        Text airport_name = iter.next();
        int quantity = 0;
        float sum = 0;
        if (iter.hasNext()) {
            float min = MIN, max = MAX;
            while (iter.hasNext()){
                String delay_str = String.valueOf(iter.next());
                float delay = Float.parseFloat(delay_str);
                ++quantity;
                sum += delay;
                min = Math.min(min, delay);
                max = Math.min(max, delay);
            }
        }
        context.write(new Text(airport_name), new LongWritable());
    }
}
