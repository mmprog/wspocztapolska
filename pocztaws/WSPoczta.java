package pocztaws;

import java.io.IOException;
import java.util.Date;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParserException;

public class WSPoczta {
	private final String NAMESPACE = "http://sledzenie.pocztapolska.pl";
	private final String AX21 = "http://ws.sledzenie.pocztapolska.pl/xsd";
	
	private final String URL = "https://tt.poczta-polska.pl/Sledzenie/services/Sledzenie?wsdl";
	
	private final String SOAP_ACTION = "http://tt.sledzenie.pocztapolska.pl/sprawdzPrzesylke";
	private final String METHOD_NAME = "sprawdzPrzesylke";
	private final String RESPONSE_OUTER_BOX = "sprawdzPrzesylkeResponse";
	
	private final String SOAP_ACTION_EX = "http://tt.sledzenie.pocztapolska.pl/sprawdzPrzesylkePl";
	private final String METHOD_NAME_EX = "sprawdzPrzesylkePl";
	private final String RESPONSE_OUTER_BOX_EX = "sprawdzPrzesylkePlResponse";
	
	private final String USERNAME = "sledzeniepp";
	private final String USERPASSWORD = "PPSA";
	
	void addSecurityHeader(SoapSerializationEnvelope envelope){
	    Element headers[] = new Element[1];
	    headers[0]= new Element().createElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
	    headers[0].setAttribute(envelope.env, "mustUnderstand", "1");
	    Element security=headers[0];

	    Element token = new Element().createElement(security.getNamespace(), "UsernameToken");
	    token.setAttribute("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Id", "UsernameToken-2");

	    Element username = new Element().createElement(security.getNamespace(), "Username");
	    username.addChild(Node.TEXT, USERNAME);
	    token.addChild(Node.ELEMENT,username);

	    Element password = new Element().createElement(security.getNamespace(), "Password");
	    password.setAttribute(null, "Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
	    password.addChild(Node.TEXT, USERPASSWORD);
	    token.addChild(Node.ELEMENT,password);
	    
	    headers[0].addChild(Node.ELEMENT, token);

	    envelope.headerOut = headers;
	}
	
	void addMappings(SoapSerializationEnvelope envelope, String outerBox){
	    //structures mapping
	    envelope.addMapping(NAMESPACE, outerBox, WSResponse.class);
	    envelope.addMapping(AX21, "Przesylka", Komunikat.class);
	    envelope.addMapping(AX21, "DanePrzesylki", DanePrzesylki.class);
	    envelope.addMapping(AX21, "ListaZdarzen", PropertyInfo.VECTOR_CLASS);
	    envelope.addMapping(AX21, "Jednostka", Jednostka.class);
	    envelope.addMapping(AX21, "Zdarzenie", Zdarzenie.class);
	    
	    //primitives mapping
	    MarshalDateCustom marshalDateCust=new MarshalDateCustom();
	    MarshalDouble marshalDouble=new MarshalDouble();
	    
	    //what we dealing with here is the total lack of respect for the law
	    //null mapping and any name (different name for each mapping)
	    //so marshaller will be choosen by type requested in parent KVMSerializable
	    envelope.addMapping(null, "Date", Date.class, marshalDateCust);
	    envelope.addMapping(null, "Double", Double.class, marshalDouble );
	}
	
	SoapObject createRequestParameter(String code, String methodName){
		SoapObject request = new SoapObject(NAMESPACE, methodName);
		PropertyInfo name = new PropertyInfo();
	    name.setNamespace(NAMESPACE);
	    name.setName("numer");
	    name.setValue(code);
	    name.setType(String.class);
	    request.addProperty(name);
	    
	    return request;
	}
	
	Komunikat getWSResponse(String code, String soapAction, String methodName, String outerBox) 
				throws HttpResponseException, IOException, XmlPullParserException{
	    //create envelope
	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    envelope.implicitTypes=false;
	    
	    addSecurityHeader(envelope);
	    addMappings(envelope, outerBox);
	    
	    envelope.setOutputSoapObject(createRequestParameter(code, methodName));
	    
	    //WS call
	    HttpTransportSE transport = new HttpTransportSE(URL);
//    	transport.debug = true;
    	transport.call(soapAction, envelope);
	        
        WSResponse response = (WSResponse) envelope.bodyIn;
		return response.getKomunikat();
	}

	public Komunikat getPrzesylka(String code) 
			throws HttpResponseException, IOException, XmlPullParserException{
		return getWSResponse(code, SOAP_ACTION, METHOD_NAME, RESPONSE_OUTER_BOX);
	}
	
	public Komunikat getPrzesylkaEx(String code)
			throws HttpResponseException, IOException, XmlPullParserException{
		return getWSResponse(code, SOAP_ACTION_EX, METHOD_NAME_EX, RESPONSE_OUTER_BOX_EX);
	}
}
