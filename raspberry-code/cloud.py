import requests
import threading
import time

BASE_API_URL = 'localhost'

class Cloud:

    def __init__(self, device, cbk):
        self.device = device
        self.cbk = cbk
        self.state = None
        thread = threading.Thread(target=self.loop, args=())
        thread.daemon = True
        thread.start()

    def loop(self):
        while True:
            new_state = requests.get(BASE_API_URL + self.device).json()
            if new_state is None or new_state != self.state:
                self.cbk(new_state)
                self.state = new_state
            time.sleep(1)

    def set_state(self, state):
        self.state = state
        requests.post(BASE_API_URL + self.device, json=state)
