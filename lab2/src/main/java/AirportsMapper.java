import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split(",");
        if (key.get() > 0){
            String airport_name = "";
            for (int i = 1; i < line.length; i++) {
                airport_name += line[i];
            }
            context.write(
                    new FlightsWritableComparable(Integer.parseInt(line[0]), 0),
                    new Text(airport_name)
            );
        }
    }
}
