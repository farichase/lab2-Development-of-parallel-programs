import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class MapSideJoin {
    public static void main (String[] args) throws Exception{
        if (args.length != 2) {
            System.exit(-1);
        }
        JobConf conf = new JobConf(MapSideJoin.class);
        conf.setJobName("map join");
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        conf.setMapperClass(MapJoinMapper.class);
        conf.setOutputKeyClass(Text.class);
        JobClient.runJob(conf);
    }
}
