from gpiozero import LED
from cloud import Cloud
from time import sleep

def make_coffee():
    i = 0
    while(i < 200):
        s.on()
        sleep(0.0019)
        s.off()
        sleep(0.0015)
        i += 1

    sleep(1)

    while(i > 0):
        s.on()
        sleep(0.0023)
        s.off()
        sleep(0.0015)
        i -= 2

def callback(state):
    if state['state']:
        print('Making coffee')
        make_coffee()
        print('Finished making coffee')
        cloud.set_state({'state': False})
    else:
        print('Make coffee state changed')

s = LED(4)
cloud = Cloud('coffee', callback)
while True:
    sleep(1)
