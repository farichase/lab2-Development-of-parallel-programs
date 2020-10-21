import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightsWritableComparable implements WritableComparable<FlightsWritableComparable> {
    private int aeroport_id;
    private int indicator;
    public FlightsWritableComparable(int aeroport_id, int indicator){
        this.aeroport_id = aeroport_id;
        this.indicator = indicator;
    }
    @Override
    public void write(DataOutput data) throws IOException {
        data.writeInt(aeroport_id);
        data.writeInt(indicator);
    }
    @Override
    public void readFields(DataInput data) throws IOException{
        aeroport_id = data.readInt();
        indicator = data.readInt();
    }
    @Override
    public int compareTo(FlightsWritableComparable item){
        return 0;
    }
}
