package airports;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightsWritableComparable implements WritableComparable<FlightsWritableComparable> {
    private int airport_id;
    private int indicator;
    public FlightsWritableComparable(int airport_id, int indicator){
        this.airport_id = airport_id;
        this.indicator = indicator;
    }
    public FlightsWritableComparable(){
        this.airport_id = 0;
        this.indicator = 0;
    }
    @Override
    public void write(DataOutput data) throws IOException {
        data.writeInt(this.airport_id);
        data.writeInt(this.indicator);
    }
    @Override
    public void readFields(DataInput data) throws IOException{
        this.airport_id = data.readInt();
        this.indicator = data.readInt();
    }
    public void setAeroport_id(int aeroport_id){
        this.airport_id = aeroport_id;
    }
    public void setIndicator(int indicator){
        this.indicator = indicator;
    }
    public int getAeroport_id(){
        return this.airport_id;
    }
    public int getIndicator(){
        return this.indicator;
    }
    @Override
    public int compareTo(FlightsWritableComparable item){
        if (this.airport_id > item.airport_id)
            return 1;
        else if (this.airport_id != item.airport_id)
            return -1;
        if (this.indicator > item.indicator)
            return 1;
        else if (this.indicator != item.indicator)
            return -1;
        return 0;
    }
    public int compareAirportId(FlightsWritableComparable item){
        if (this.airport_id > item.airport_id)
            return 1;
        else if (this.airport_id != item.airport_id)
            return -1;
        return 0;
    }
}
