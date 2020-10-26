import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final int AIRPORT_ID = 14;
    private static final int AIRPORT_DELAY = 18;
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split(",");
        if (key.get() > 0){
            float delay = 0.f;
            if (line[AIRPORT_DELAY].trim().length() != 0) {
                delay = Float.parseFloat(line[AIRPORT_DELAY]);
            }
            if (delay > 0.f) {
                int airport_id = Integer.parseInt(line[AIRPORT_ID]);
                context.write(
                        new FlightsWritableComparable(airport_id, 1),
                        new Text(String.valueOf(delay))
                );
            }
        }
    }
}