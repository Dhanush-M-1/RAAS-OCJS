# -*- coding: utf-8 -*-
def reading(pages, speed, max_speed, busting, fee):
    days = 1
    pages -= speed
    if pages <= 0:
        return days
    while (speed +  days*busting <= max_speed and pages > 0):
        pages -= -fee + days*busting + speed
        days += 1
        if pages <= 0:
            break
    while (speed + fee + days*busting > max_speed and pages > 0):    
        pages -= -fee +max_speed
        days += 1
        if pages <= 0:
            break
    return days


d = input()
a,b,c,f,e = d.split(' ')
print (reading(int(a),int(b),int(c),int(f),int(e)))         
