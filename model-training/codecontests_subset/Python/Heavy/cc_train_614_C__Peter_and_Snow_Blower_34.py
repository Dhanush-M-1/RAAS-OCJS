from math import sqrt, inf, pi

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def dis(a, b):
    return sqrt((a.x - b.x) ** 2 + (a.y - b.y) ** 2)
def dcmp(x, eps = 1e-10):
    return 0 if abs(x) < eps else -1 if x < 0 else 1
def dot(a, b):
    return a.x * b.x + a.y * b.y
def cross(a, b):
    return a.x * b.y - a.y * b.x
def eq(a, b):
    return dcmp(a.x - b.x) == 0 and dcmp(a.y - b.y) == 0

n, sx, sy = map(int, input().split())
s = Point(sx, sy)
maxdis = 0
mindis = inf
pts = []

for i in range(n):
    tx, ty = map(int, input().split())
    t = Point(tx, ty)
    ds = dis(s, t)
    pts.append(t)
    if ds > maxdis:
        maxdis = ds

for i in range(n):
    a = pts[i]
    b = pts[(i + 1) % n]
    if eq(a, b):
        ds = dis(s, a)
    else:
        v1 = Point(b.x - a.x, b.y - a.y)
        v2 = Point(s.x - a.x, s.y - a.y)
        v3 = Point(s.x - b.x, s.y - b.y)
        if dcmp(dot(v1, v2)) < 0:
            ds = dis(Point(0, 0), v2)
        elif dcmp(dot(v1, v3)) > 0:
            ds = dis(Point(0, 0), v3)
        else:
            ds = abs(cross(v1, v2)) / dis(Point(0, 0), v1)
    if ds < mindis:
        mindis = ds

print('%.6f' % (pi * maxdis ** 2 - pi * mindis ** 2))

   	 		 	  	 	    			   				 	