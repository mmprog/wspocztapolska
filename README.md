wspocztapolska
==============

Client of Poczta Polska registered parcels tracking WS as described at:
http://www.poczta-polska.pl/webservices/

Main class WSPoczta. Using ksoap2-android.

Public methods:
* public Komunikat getPrzesylka(String code)
* public Komunikat getPrzesylkaEx(String code) code - parcel number

getPrzesylkaEx - return also detailed description of post office for event in Jednoska::daneSzczegolowe. For getPrzesylka field daneSzczegolowe is set to null.
 
----------------------------------------

Klient usługi webservice do śledzenia przesyłek rejestrowanych Poczta Polska dla klientów indywidualnych.

Biblioteczka przeznaczona dla systemu Android, wykonana z użyciem biblioteki ksoap2-android.

----------------------------------------
Licence
=======

   Copyright 2014 Marcin Milczarz MMPROGRAMIST

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
