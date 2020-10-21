import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class AirportsReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    @Override
    protected void reduce(FlightsWritableComparable key, Iterable<Text> value, Context context){
        
    }
}
