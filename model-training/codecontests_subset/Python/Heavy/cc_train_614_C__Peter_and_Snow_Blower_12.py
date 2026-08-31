
from math import pi


def getl(p1, p2):
    x1, y1 = p1
    x2, y2 = p2
    return(pow((x1-x2)**2+(y1-y2)**2, 0.5))

def geth(a, b, c):
    z = getl(c,b)
    return abs((b[1] - c[1])*a[0]+(c[0]-b[0])*a[1]+b[0]*c[1]-c[0]*b[1]) / z

def getp(a, b):
    return(pow(abs(a**2-b**2), 0.5))

n, x, y = map(int, input().split())
P = (x, y)
p = [0] * n
for i in range(n):
    p[i] = tuple(map(int,input().split()))\
        
mini = int(2e9)
maxi = 0
for i in range(n):
    if maxi < getl(P, p[i]): maxi = getl(P, p[i])
    if mini > getl(P, p[i]): mini = getl(P, p[i])
for i in range(-1, n-1):
    h = geth(P, p[i], p[i+1])
    t = getp(getl(P, p[i]), h) + getp(getl(P, p[i+1]), h)
    if  t + 1e-3 >= getl(p[i], p[i + 1]) >= t - 1e-3:
        if h < mini: mini = h
        
        
        
print(pi * (maxi ** 2 - mini ** 2))

    