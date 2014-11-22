package pocztaws;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class Jednostka implements KvmSerializable {

	private SoapObject daneSzczegolowe;
	private String nazwa;
	
	@Override
	public Object getProperty(int arg0) {
		switch(arg0){
		case 0: return daneSzczegolowe;
		case 1: return nazwa;
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
		case 0: arg2.name="daneSzczegolowe"; arg2.type=SoapObject.class; break;
		case 1: arg2.name="nazwa"; arg2.type=PropertyInfo.STRING_CLASS; break;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch(arg0){
		case 0: daneSzczegolowe=(SoapObject)arg1; break;
		case 1: nazwa=(String)arg1;
		}
	}

	public SoapObject getDaneSzczegolowe() {
		return daneSzczegolowe;
	}

	public void setDaneSzczegolowe(SoapObject daneSzczegolowe) {
		this.daneSzczegolowe = daneSzczegolowe;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}
