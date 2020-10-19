import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;

public class JoinApp {
    public static void main (String[] args) throws Exception{
        if (args.length != 3) {
            System.exit(-1);
        }
        JobConf conf = new JobConf(JoinApp.class);
        conf.setJobName("JoinApp");
        MultipleInputs.addInputPath(conf, args[0], TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(conf, args[1], TextInputFormat.class, AirportMapper.class);
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        conf.setOutputKeyClass(Text.class);
        JobClient.runJob(conf);
    }
}
