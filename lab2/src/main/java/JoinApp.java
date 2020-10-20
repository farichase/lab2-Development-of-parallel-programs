import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.jobcontrol.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;

public class JoinApp {
    public static void main (String[] args) throws Exception{
        if (args.length != 3) {
            System.exit(-1);
        }
        Configuration conf = 
        Job job = new Job();
        job.setJobName("JoinApp");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        JobClient.runJob(job);
    }
}
