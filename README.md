
# Coding 4 Kids: IoT Connect Everything powered by Catalysts

Das Projekt besteht aus verschiedenen Raspberrys Pi's welche über eine  (REST-) Schnittstelle
einen vordefinierten Status im Internet veröffentlichen bzw. abfragen können. Um mit den Geräten
über diese Schnittstelle zu kommunizieren beinhaltet das Projekt eine Android-Handy Applikation und einen Alexa-Skill.

Das Projekt beinhaltet folgende Teile:
  - Raspbery Pi Anleitung für die GPIO Belegung
  - Raspbery Pi Anleitung für den Code zur Kommunikation
  - Node.js Code für den REST-Server
  - Android APP Code
  - Alexa Skill Interaktions Modell
  - AWS Lambda Funktion zur Kommunikation mit dem Alexa-Skill
  
![alt text](https://image.ibb.co/nmLiVe/catalysts_iot.jpg)

### Voraussetzungen

Folgende Accounts und Komponenten sind notwendig für dieses Projekt:
  - Amazon Developer Account (https://developer.amazon.com/de/)
  - Amazon Web Service Account (https://aws.amazon.com/de/
  - Hosting-Provider für den REST-Server (z.B. https://www.openode.io/)
  - Raspberry Pi Model 3
  - Sensoren deiner Wahl (z.B. Sense Hat) 
  - Detailierte Komponenten unter: 
  

### Technologien
Das Projekt beinhaltet folgende Programmiersprachen:
  - Android App: Java/Kotlin
  - Raspberry PI - Python 3
  - REST-Server und Lambda Function: JavaScript (Node.js)


### Vorwissen und Lektüre
Um sich mit dem Thema intensiver ausseinander zu setzen empfehlen wir folgende Artikel: 
    - Was ist IoT: https://aws.amazon.com/de/iot/
    
### Technische Abgrenzung
In diesem Projekt wurde ein simpler Node.js REST-Server für den Austausch der Geräte zur Verfügung gestellt. Die Raspberrys veröffentlichen bzw. erfragen den Status via (Long-)Polling bzw. wiederholtes Abfragen des Zustandes via HTTP in kleinen Zeitabständen Diese Umsetzung dient lediglich zur einfachen Veranschaulichung des Sachverhaltes und sollte in Produktiv System mit passenderen Lösungen wie MQTT (https://de.wikipedia.org/wiki/MQTT) oder Websockets (https://de.wikipedia.org/wiki/WebSocket) realisiert werden. Das Senden der Statusänderungen allerdings über die Android-App oder den Alexa-Skill kann durchaus via REST-Calls auch in Produktiv-Systemen realisiert werden.

