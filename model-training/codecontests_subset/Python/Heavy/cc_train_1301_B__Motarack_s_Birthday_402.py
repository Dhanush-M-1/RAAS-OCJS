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


# Code
t = intput()
for _ in range(t):
    n = intput()
    a = list(intsput())
    b = []
    for i in range(n):
        if a[i] == -1:
            for j in (i - 1, i + 1):
                if j in range(n) and a[j] != -1:
                    b.append(a[j])
    
    if not b:
        print(0, 10)
        continue
    
    large = max(b)
    small = min(b)
    k = small + (large - small) // 2

    for i in range(n):
        if a[i] == -1:
            a[i] = k

    found = 0
    for i in range(1, n):
        found = max(found, abs(a[i] - a[i - 1]))

    print(found, k)
