package pocztaws;

import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DanePrzesylki implements KvmSerializable {
	private Date dataNadania;
	private String kodKrajuNadania;
	private String kodKrajuPrzezn;
	private String kodRodzPrzes;
	private String krajNadania;
	private String krajPrzezn;
	private double masa;
	private String numer;
	private String rodzPrzes;
	private Jednostka urzadNadania;
	private Jednostka urzadPrzezn;
	private boolean zakonczonoObsluge;
	private Vector<Zdarzenie> zdarzenia;
	
	@Override
	public Object getProperty(int arg0) {
		switch(arg0){
		case 0: return dataNadania;
		case 1: return kodKrajuNadania;
		case 2: return kodKrajuPrzezn;
		case 3: return kodRodzPrzes;
		case 4: return krajNadania;
		case 5: return krajPrzezn;
		case 6: return masa;
		case 7: return numer;
		case 8: return rodzPrzes;
		case 9: return urzadNadania;
		case 10: return urzadPrzezn;
		case 11: return zakonczonoObsluge;
		case 12: return zdarzenia;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 13;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch(arg0){
		case 0: arg2.name="dataNadania"; arg2.type=Date.class; break;
		case 1: arg2.name="kodKrajuNadania"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 2: arg2.name="kodKrajuPrzezn"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 3: arg2.name="kodRodzPrzes"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 4: arg2.name="krajNadania"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 5: arg2.name="krajPrzezn"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 6: arg2.name="masa"; arg2.type=Double.class; break;
		case 7: arg2.name="numer"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 8: arg2.name="rodzPrzes"; arg2.type=PropertyInfo.STRING_CLASS; break;
		case 9: arg2.name="urzadNadania"; arg2.type=Jednostka.class; break;
		case 10: arg2.name="urzadPrzezn"; arg2.type=Jednostka.class; break;
		case 11: arg2.name="zakonczonoObsluge"; arg2.type=PropertyInfo.BOOLEAN_CLASS; break;
		case 12: arg2.name="zdarzenia"; arg2.type=PropertyInfo.VECTOR_CLASS; break;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch(arg0){
		case 0: dataNadania=(Date)arg1;break;
		case 1: kodKrajuNadania=(String)arg1;break;
		case 2: kodKrajuPrzezn=(String)arg1;break;
		case 3: kodRodzPrzes=(String)arg1;break;
		case 4: krajNadania=(String)arg1;break;
		case 5: krajPrzezn=(String)arg1;break;
		case 6: masa=(Double)arg1;break;
		case 7: numer=(String)arg1;break;
		case 8: rodzPrzes=(String)arg1;break;
		case 9: urzadNadania=(Jednostka)arg1;break;
		case 10: urzadPrzezn=(Jednostka)arg1;break;
		case 11: zakonczonoObsluge=(boolean)arg1;break;
		case 12: zdarzenia=(Vector<Zdarzenie>)arg1;break;
		}
	}

	public Date getDataNadania() {
		return dataNadania;
	}

	public void setDataNadania(Date dataNadania) {
		this.dataNadania = dataNadania;
	}

	public String getKodKrajuNadania() {
		return kodKrajuNadania;
	}

	public void setKodKrajuNadania(String kodKrajuNadania) {
		this.kodKrajuNadania = kodKrajuNadania;
	}

	public String getKodKrajuPrzezn() {
		return kodKrajuPrzezn;
	}

	public void setKodKrajuPrzezn(String kodKrajuPrzezn) {
		this.kodKrajuPrzezn = kodKrajuPrzezn;
	}

	public String getKodRodzPrzes() {
		return kodRodzPrzes;
	}

	public void setKodRodzPrzes(String kodRodzPrzes) {
		this.kodRodzPrzes = kodRodzPrzes;
	}

	public String getKrajNadania() {
		return krajNadania;
	}

	public void setKrajNadania(String krajNadania) {
		this.krajNadania = krajNadania;
	}

	public String getKrajPrzezn() {
		return krajPrzezn;
	}

	public void setKrajPrzezn(String krajPrzezn) {
		this.krajPrzezn = krajPrzezn;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getRodzPrzes() {
		return rodzPrzes;
	}

	public void setRodzPrzes(String rodzPrzes) {
		this.rodzPrzes = rodzPrzes;
	}

	public Jednostka getUrzadNadania() {
		return urzadNadania;
	}

	public void setUrzadNadania(Jednostka urzadNadania) {
		this.urzadNadania = urzadNadania;
	}

	public Jednostka getUrzadPrzezn() {
		return urzadPrzezn;
	}

	public void setUrzadPrzezn(Jednostka urzadPrzezn) {
		this.urzadPrzezn = urzadPrzezn;
	}

	public boolean isZakonczonoObsluge() {
		return zakonczonoObsluge;
	}

	public void setZakonczonoObsluge(boolean zakonczonoObsluge) {
		this.zakonczonoObsluge = zakonczonoObsluge;
	}

	public Vector<Zdarzenie> getZdarzenia() {
		return zdarzenia;
	}

	public void setZdarzenia(Vector<Zdarzenie> zdarzenia) {
		this.zdarzenia = zdarzenia;
	}

}
