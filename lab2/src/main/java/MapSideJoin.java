import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.util.List;

public class MapSideJoin {
    public static void main (String[] args) throws Exception{
        if (args.length != 2) {
            System.exit(-1);
        }
        JobConf conf = new JobConf(MapSideJoin.class);
        conf.setJobName("map join");
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        TextInputFormat inputFormat = new TextInputFormat();
        InputSplit[] splits = inputFormat.getSplits(conf);
        conf.setMapperClass(MapJoinMapper.class);
        conf.setOutputKeyClass(Text.class);
        JobClient.runJob(conf);
    }
}
