from sys import stdin
from bisect import bisect_left as bl
from bisect import bisect_right as br

def input():
    return stdin.readline()[:-1]


def intput():
    return int(input())


def sinput():
    return input().split()


def intsput():
    return map(int, sinput())


class RangedList:
    def __init__(self, start, stop, val=0):
        self.shift = 0 - start
        self.start = start
        self.stop = stop
        self.list = [val] * (stop - start)

    def __setitem__(self, key, value):
        self.list[key + self.shift] = value

    def __getitem__(self, key):
        return self.list[key + self.shift]

    def __repr__(self):
        return str(self.list)

    def __iter__(self):
        return iter(self.list)


def dprint(*args, **kwargs):
    if debugging:
        print(*args, **kwargs)


debugging = 1
t = intput()
for _ in range(t):
    n, m = intsput()
    a = set(intsput())
    b = set(intsput())
    ans = False
    for x in a:
        if x in b:
            ans = True
            break

    if not ans:
        print('NO')
    else:
        print('YES')
        print(1, x)
