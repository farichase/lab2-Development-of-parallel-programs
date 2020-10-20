import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static int AIRPORT_ID = 14;
    private static int AIRPORT_DELAY = 18;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split(",");
        if (key.get() > 0){
            float delay = 0.f;
            if (line[AIRPORT_DELAY].trim().length() != 0) {
                delay = Float.parseFloat(line[AIRPORT_DELAY]);
            }
            if (delay > 0) {
                context.write(
                        new AirportWritableComparable(Integer.parseInt(line[AIRPORT_ID]), 1),
                        new Text(line[AIRPORT_DELAY]));
            }
        }
    }
}