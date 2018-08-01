import time
from gpiozero import LED
from cloud import Cloud

r = LED(17)
b = LED(27)
g = LED(22)
def callback(state):
    color = state.get('color', 'off')
    print('light changed', color)
    if color == 'rot':
        r.on()
        g.off()
        b.off()
    elif color == 'blau':
        r.off()
        g.off()
        b.on()
    elif color == u'gr\xfcn':
        r.off()
        g.on()
        b.off()
    elif color == 'cyan':
        r.off()
        g.on()
        b.on()
    elif color == 'gelb':
        r.on()
        g.on()
        b.off()
    elif color == 'violett':
        r.on()
        g.off()
        b.on()
    elif color == u'wei\xdf':
        r.on()
        g.on()
        b.on()
    elif color == 'aus':
        r.off()
        g.off()
        b.off()

cloud = Cloud('light', callback)
while True:
    time.sleep(1)
