# url: https://codeforces.com/contest/851/problem/b
# tag:
# difficulty:
from typing import List

INF = float("inf")
NINF = float("-inf")


def read_string():
    return input()


def read_string_line():
    return [x for x in input().split(" ")]


def read_int_line():
    return [int(x) for x in input().split(" ")]


def read_int():
    return int(input())


def get_int_arr(s):
    return [int(x) for x in s.split()]


def get_sum(acc, l, r):
    """
     l, r are original index
     """
    return acc[r] - acc[l]


P = int(1e9 + 7)


def exgcd(x, y):
    if y == 0:
        return x, 1, 0
    g, a, b = exgcd(y, x % y)
    t = x // y
    return g, b, a - t * b


def inv(x):
    g, a, b = exgcd(x, P)
    return a


def calc_acc(arr):
    ans = [0]
    for a in arr:
        ans.append(a + ans[-1])
    return ans


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __sub__(self, other):
        return Point(self.x - other.x, self.y - other.y)

    def __add__(self, other):
        return Point(self.x + other.x, self.y + other.y)

    def __mul__(self, other):
        return Point(self.x * other, self.y * other)

    def dot(self, other):
        return self.x * other.x + self.y * other.y

    def cross(self, other):
        return self.x * other.y - self.y * other.x

    def abs(self):
        return self.abs2() ** 0.5

    def abs2(self):
        return self.dot(self)

    def dist(self, other):
        return (self - other).abs()

    def dist2(self, other):
        return (self - other).abs2()

    def __str__(self):
        return "Point(%s, %s)" % (self.x, self.y)


def get_point(line):
    x, y = get_int_arr(line)
    return Point(x, y)


lines: List[str] = [*open(0)]
ax, ay, bx, by, cx, cy = get_int_arr(lines[0])
a = Point(ax, ay)
b = Point(bx, by)
c = Point(cx, cy)
ok = (a - b).abs2() == (b - c).abs2() and (a + c - b * 2).abs() != 0

print("%s" % ("Yes" if ok else "No"))
