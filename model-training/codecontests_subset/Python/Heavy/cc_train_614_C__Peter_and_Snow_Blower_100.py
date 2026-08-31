#!/bin/python3

import math
n,x,y = map(int, input().split())
mnd = -1;
mxd = -1;
ans = [0] * 4;
fx,fy = 0, 0
px,py = 0, 0

def intersect(x1,y1,x2,y2,x3,y3):
    x = x2 - x1
    y = y2 - y1
    x3 -= x1
    y3 -= y1
    lsquare = x**2 + y **2
    t = max(0, min((x * x3 + y * y3) / lsquare,1))
    px = x * t
    py = y * t
    d = (x3 - px)**2 + (y3 - py)**2
    return d
    
    
for i in range(n):
    x1,y1 = map(int, input().split())
    dx = (x1 - x);
    dy = (y1 - y);
    d =  dx ** 2 + dy ** 2
    if mnd == -1 or mnd > d:
        mnd = d
    if mxd == -1 or mxd < d:
        mxd = d
    if i > 0:
        d= intersect(x1,y1,px,py,x,y)
        if mxd < d:
            mxd = d
        if mnd > d:
            mnd = d
    if  i > 0:
        px, py = x1,y1
    else:
        fx,fy,px,py = x1,y1,x1,y1
d = intersect(x1,y1,fx,fy,x,y)
if mxd < d:
    mxd = d
if mnd > d:
    mnd = d
print("%.6f"% (math.pi*((mxd -mnd))))