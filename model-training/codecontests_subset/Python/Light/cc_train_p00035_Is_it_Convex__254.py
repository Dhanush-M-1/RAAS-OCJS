import sys


class Vector(object):
    def __init__(self, _from, to):
        self.x = to[0]-_from[0]
        self.y = to[1]-_from[1]

    def cross(self, other: "Vector") -> float:
        return self.x * other.y - self.y * other.x


for a in (list(map(float, l.split(","))) for l in sys.stdin):
    points = [(x, y) for x, y in zip(a[::2], a[1::2])]
    sign = {Vector(p2, p3).cross(Vector(p2, p1)) > 0
            for p1, p2, p3 in zip(points, points[1:]+points, points[2:]+points)}
    print("YES" if len(sign) == 1 else "NO")
