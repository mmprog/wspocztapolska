wspocztapolska
==============

Client of Poczta Polska registered parcels tracking WS as described at:
http://www.poczta-polska.pl/webservices/

Main class WSPoczta. Using ksoap2-android.

Public methods:
* public Komunikat getPrzesylka(String code)
* public Komunikat getPrzesylkaEx(String code) code - parcel number

getPrzesylkaEx - return also detailed description of post office for event in Jednoska::daneSzczegolowe. For getPrzesylka field daneSzczegolowe is set to null.
 
