import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static int AEROPORT_ID = 14;
    private static int ARR_DELAY = 18;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split(",");
        if (key.get() > 0){
            float delay = 0.f;
            if (line[ARR_DELAY].trim().length() != 0) {
                delay = Float.parseFloat(line[ARR_DELAY]);
            }
            if (delay > 0) {
                //context.write(new , new Text(line[ARR_DELAY]));
            }
        }
    }
}