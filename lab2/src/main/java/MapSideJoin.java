import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;

public class MapSideJoin {
    public static void main (String[] args) throws Exception{
        if (args.length != 2) {
            System.exit(-1);
        }
        JobConf conf = new JobConf(JoinJob.class);
        conf.setJobName("map join");
        FileOutputFormat
    }
}
