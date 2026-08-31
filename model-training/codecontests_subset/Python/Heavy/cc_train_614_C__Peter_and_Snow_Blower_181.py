class Point(object):
    def __init__(self, x, y):
        self.x = float(x)
        self.y = float(y)

def square(x):
    return x * x

def distance_squared(v, w):
    return square(v.x - w.x) + square(v.y - w.y)

def distance_point_segment_squared(p, v, w):
    # Segment length squared, |w-v|^2
    d2 = distance_squared(v, w) 
    if d2 == 0: 
        # v == w, return distance to v
        return distance_squared(p, v)
# Consider the line extending the segment, parameterized as v + t (w - v).
  # We find projection of point p onto the line.
  # It falls where t = [(p-v) . (w-v)] / |w-v|^2
    t = ((p.x - v.x) * (w.x - v.x) + (p.y - v.y) * (w.y - v.y)) / d2;
    if t < 0:
        # Beyond v end of the segment
        return distance_squared(p, v)
    elif t > 1.0:
        # Beyond w end of the segment
        return distance_squared(p, w)
    else:
        # Projection falls on the segment.
        proj = Point(v.x + t * (w.x - v.x), v.y + t * (w.y - v.y))
    # print proj.x, proj.y
        return distance_squared(p, proj)

n, x, y = map(int, input().split())
pt = [tuple(map(int, input().split())) for i in range(n)]
pt = [Point(p[0] - x, p[1] - y) for p in pt]

p0 = Point(0, 0)

mind = float('+inf')
maxd = float('-inf')
for i in range(len(pt)):
    cd = distance_point_segment_squared(p0, pt[i-1], pt[i])
    mind = min(mind, cd)
    cd = distance_squared(p0, pt[i])
    maxd = max(maxd, cd)

from math import pi

s1 = pi * maxd
s2 = pi * mind

print(s1 - s2)
