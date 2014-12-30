package pocztaws;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class Komunikat implements KvmSerializable{
	private int status;	
	private String numer;
	private DanePrzesylki danePrzesylki;
	
	public Komunikat(){}
	 
	public Komunikat(int status, String numer, DanePrzesylki danePrzesylki) {
		super();
		this.status = status;
		this.numer = numer;
		this.danePrzesylki = danePrzesylki;
	}

	@Override
	public Object getProperty(int arg0) {
		switch(arg0){
		case 0: return Integer.valueOf(status);
		case 1: return numer;
		case 2: return danePrzesylki;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 3;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch(arg0){
		case 0: arg2.name="status"; arg2.type=PropertyInfo.INTEGER_CLASS; break;
		case 1: arg2.name="numer"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 2: arg2.name="danePrzesylki"; arg2.type=DanePrzesylki.class; break;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch(arg0){
		case 0: status=((Integer)arg1).intValue();break;
		case 1: numer=(String)arg1;break;
		case 2: danePrzesylki=(DanePrzesylki)arg1;break;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public DanePrzesylki getDanePrzesylki() {
		return danePrzesylki;
	}

	public void setDanePrzesylki(DanePrzesylki danePrzesylki) {
		this.danePrzesylki = danePrzesylki;
	}
	
}
