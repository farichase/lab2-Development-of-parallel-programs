import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
    private int aeroport_id;
    public AirportWritableComparable(){

    }
    @Override
    public void write(DataOutput data) {

    }
    @Override
    public void readFields(DataInput data){

    }
    @Override
    public int compareTo(AirportWritableComparable item){

    }
}
