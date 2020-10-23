import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportsReducer extends Reducer<FlightsWritableComparable, Text, Text, Text> {
    float MAX = 0.f;
    float MIN = Float.MAX_VALUE;
    @Override
    protected void reduce(FlightsWritableComparable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text airport_name = iter.next();
        if (iter.hasNext()) {
            int quantity = 0;
            float sum = 0, min = MIN, max = MAX;
            String delay_str = String.valueOf(iter.next());
            float delay = Float.parseFloat(delay_str);
            System.out.println(delay);
            ++quantity;
            sum += delay;
            min = Math.min(min, delay);
            max = Math.min(max, delay);
            while (iter.hasNext()){
                delay_str = String.valueOf(iter.next());
                delay = Float.parseFloat(delay_str);
                ++quantity;
                sum += delay;
                min = Math.min(min, delay);
                max = Math.min(max, delay);
            }
        }
        context.write(airport_name,
                new Text ("\n" + "Min delay: " + min + "\n" + "Max delay: " + max + "\n" + "Average delay : " +  sum / quantity + "\n"));
    }
}
