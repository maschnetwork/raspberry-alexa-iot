<h1>Controlling IoT devices using Android</h1>
<h3>Coding4Kids Challenge</h3>

<h3>Setup</h3>

* Download and install Android Studio.
* Checkout this repository.
* Wait for gradle to do its job (fetching dependencies)
* Either setup a new Virtual Device or connect your Smartphone via USB, with USB-Debugging enabled.
* Install the application by pressing the green arrow in Android Studio.


<h3>What this App does</h3>
This app is intended for use within the Coding4Kids IoT Challenge. It connects to a RESTful Webservice and controls three Raspberries:

* One is connected with a coffee machine (Button "Kaffee")
* Another one is equipped with a Sensor Hat and retrieves Temperature, Pressure and Humidity
* The third is connected to an LED Strip, by pressing the colored buttons you can change the color of the light.

<h3>How the App does this</h3>
The application uses a RestService to call a Webservice to get or post the corresponding functions. CoffeeService, LightService and TemperatureService use this RestService
and deliver the answers back to the Main-GUI Thread.
