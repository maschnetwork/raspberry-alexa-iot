import time
import subprocess
from cloud import Cloud
from sense_hat import SenseHat

def get_cpu_temperature():
    cpu_temp = subprocess.check_output("vcgencmd measure_temp", shell=True)
    cpu_temp = cpu_temp.split("=")
    cpu_temp = cpu_temp[1].split("'")
    cpu_temp = float(cpu_temp[0])
    return cpu_temp

cloud = Cloud('temperature', lambda x: x)
sense = SenseHat()
while True:
    # send state to Cloud

    temperature = sense.get_temperature()
    temperature = temperature - ((get_cpu_temperature() - temperature) / 5.466)
    temperature = round(temperature, 2)
    humidity = round(sense.get_humidity(), 2)
    pressure = round(sense.get_pressure(), 2)

    state = {
        'temperature': temperature,
        'humidity': humidity,
        'pressure': pressure,
    }
    sense.show_message(str(int(state['temperature'])), 0.1)
    print(state)
    cloud.set_state(state)
    time.sleep(1)
