package pocztaws;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.kobjects.isodate.IsoDate;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class MarshalDateCustom implements Marshal
{
	SimpleDateFormat dateFormat;
	SimpleDateFormat dateTimeFormat;
	
	public MarshalDateCustom(){
		Locale loc=new Locale("pl","PL");
		dateFormat=new SimpleDateFormat("yyyy-MM-dd",loc);
		dateTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm",loc);
	}
	
    public Object readInstance(XmlPullParser parser, String namespace, String name, 
            PropertyInfo expected) throws IOException, XmlPullParserException {
    	
    	String nxt=parser.nextText();
    	Date parsed=null;
        try{
        	parsed=dateTimeFormat.parse(nxt);
        }catch(ParseException e){
        }
        if(parsed==null){
            try{
            	parsed=dateFormat.parse(nxt);
            }catch(ParseException e){
            }
        }
        return parsed;
    }

    public void register(SoapSerializationEnvelope cm) {
         cm.addMapping(null, "DateTime", Date.class, this);
    }

    public void writeInstance(XmlSerializer writer, Object obj) throws IOException {
         writer.text(dateFormat.format((Date)obj));
    }
    
}