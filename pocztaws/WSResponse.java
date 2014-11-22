package pocztaws;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class WSResponse implements KvmSerializable {
	private Komunikat komunikat;
	
	@Override
	public Object getProperty(int arg0) {
		if(arg0==0){
			return komunikat;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 1;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		if(arg0==0){
			arg2.name="return";
			arg2.type=Komunikat.class;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		if(arg0==0){
			komunikat=(Komunikat)arg1;
		}
	}

	public Komunikat getKomunikat() {
		return komunikat;
	}

	public void setKomunikat(Komunikat komunikat) {
		this.komunikat = komunikat;
	}



}
