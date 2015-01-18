package pocztaws;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Przyczyna implements KvmSerializable {

	private String nazwa;
	private String kod;
	
	public Przyczyna(){}
	
	@Override
	public Object getProperty(int arg0) {
		switch(arg0){
		case 0: return nazwa;
		case 1: return kod;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 2;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch(arg0){
		case 0: arg2.name="nazwa"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 1: arg2.name="kod"; arg2.type=PropertyInfo.STRING_CLASS; break;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch(arg0){
		case 0: nazwa=(String)arg1;break;
		case 1: kod=(String)arg1;break;
		}
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

}
