package pocztaws;

import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.PropertyInfo;

public class Zdarzenie implements KvmSerializable{
	private Date czas;
	private Jednostka jednostka;
	private String kod;
	private boolean konczace;
	private String nazwa;
	private String przyczyna;
	
	@Override
	public Object getProperty(int arg0) {
		switch(arg0){
		case 0: return czas;
		case 1: return jednostka;
		case 2: return kod;
		case 3: return konczace;
		case 4: return nazwa;
		case 5: return przyczyna;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 6;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch(arg0){
		case 0: arg2.name="czas"; arg2.type=MarshalDate.DATE_CLASS; break;
		case 1: arg2.name="jednostka"; arg2.type=Jednostka.class; break;
		case 2: arg2.name="kod"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 3: arg2.name="konczace"; arg2.type=PropertyInfo.BOOLEAN_CLASS; break;
		case 4: arg2.name="nazwa"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 5: arg2.name="przyczyna"; arg2.type=PropertyInfo.STRING_CLASS; break;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch(arg0){
		case 0: czas=(Date)arg1; break;
		case 1: jednostka=(Jednostka)arg1; break;
		case 2: kod=(String)arg1; break;
		case 3: konczace=(boolean)arg1; break;
		case 4: nazwa=(String)arg1; break;
		case 5: przyczyna=(String)arg1; break;
		}
	}

	public Date getCzas() {
		return czas;
	}

	public void setCzas(Date czas) {
		this.czas = czas;
	}

	public Jednostka getJednostka() {
		return jednostka;
	}

	public void setJednostka(Jednostka jednostka) {
		this.jednostka = jednostka;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public boolean isKonczace() {
		return konczace;
	}

	public void setKonczace(boolean konczace) {
		this.konczace = konczace;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getPrzyczyna() {
		return przyczyna;
	}

	public void setPrzyczyna(String przyczyna) {
		this.przyczyna = przyczyna;
	}

}
