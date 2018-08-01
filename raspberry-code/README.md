# Raspberry Station
In der Raspberry Station bauen wir 3 verschiedene Module die mit der echten Welt agieren werden. Dazu verwenden wir mehrere Raspberry-PIs (=Mini Computer).

* **Wettermodul**
Die Wetterstation ist mit einem [Sense HAT](https://www.raspberrypi.org/products/sense-hat/) ausgestattet der einen LCD-Bildschirm und mehrere Umgebungssensoren hat (Druck, Luftfeuchtigkeit, Temperatur). Die Ansteuerung der Hardwarekomponenten funktioniert über die [Sense HAT API](https://pythonhosted.org/sense-hat/api/) (Python).

* **Lichtmodul**
Das Lichtmodul steuert 3 RGB Lampen. Dazu werden wir 3 Relays verwenden (zur Ansteuerung der einzelnen Farben).

* **Kaffeemodul**
Das Kaffeemodul kann eine Kaffeemaschine durch einen Servomotor bedienen. Um den Winkel des Motors einzustellen verwenden wir die [PWM](https://de.wikipedia.org/wiki/Pulsweitenmodulation).


## Kommunikation mit der Cloud
Die Module kommunizieren mithilfe einer [REST API](https://github.com/maximilianschreiber/raspberry-alexa-iot/tree/master/connecting-rest-server) mit der Cloud. Jedes Modul ist in der Cloud mit einem Zustand hinterlegt, hört auf Änderungen des Zustandes oder kann diesen eigenhändig verändern.

| Modul  | Zustand                       | Beispiel                                             |
|--------|-------------------------------|------------------------------------------------------|
| Wetter | temperatur, feuchtigkeit, druck | temperatur = 24.30°C, feuchtigkeit = 95%, druck = 1000 |
| Licht  | farbe                         | farbe = rot                                          |
| Kaffee | status                        | status = ein                                         |


## Verwendung
```
# wettermodul
$ python wetterstation.py

# lichtmodul
python licht.py

# kaffeemodul
python kaffee.py
```
