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
    public FlightsWritableComparable(){
        this.aeroport_id = 0;
        this.indicator = 0;
    }
    @Override
    public void write(DataOutput data) throws IOException {
        data.writeInt(aeroport_id);
        data.writeInt(indicator);
    }
    @Override
    public void readFields(DataInput data) throws IOException{
        this.aeroport_id = data.readInt();
        this.indicator = data.readInt();
    }
    public void setAeroport_id(int aeroport_id){
        this.aeroport_id = aeroport_id;
    }
    public void setIndicator(int indicator){
        this.indicator = indicator;
    }
    public int getAeroport_id(){
        return this.aeroport_id;
    }
    public int getIndicator(){
        return this.indicator;
    }
    @Override
    public int compareTo(FlightsWritableComparable item){
        if (aeroport_id > item.getAeroport_id())
            return 1;
        else if (aeroport_id != item.getAeroport_id())
            return -1;
        if (indicator > item.getIndicator())
            return 1;
        else if (indicator != item.getIndicator())
            return -1;
        return 0;
    }
}
