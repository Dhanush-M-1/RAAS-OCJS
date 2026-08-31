import math
import sys
from collections import defaultdict, Counter
from itertools import groupby

#input = sys.stdin.readline
rt = lambda: map(int, input().split())
ri = lambda: int(input())
rl = lambda: list(map(int, input().split()))


class Bit:
    def __init__(self, n):
        self.size = n
        self.tree = [0] * (n+1)

    def sum(self, i):
        s = 0
        while i > 0:
            s += self.tree[i]
            i -= i & (-i)
        return s

    def add(self, i, val):
        while i <= self.size:
            self.tree[i] += val
            i += i & (-i)


def main():
    n = ri()
    x = rl()
    v = rl()
    pts = [(xi, vi) for xi, vi in zip(x, v)]
    pts.sort(key=lambda a: (a[1], a[0]))
    comprX = {val: i+1 for i, val in enumerate(sorted(x))}
    bit_x = Bit(n+1)
    bit_cnt = Bit(n+1)

    res = 0
    for xi, vi in pts:
        compr = comprX[xi]
        res += bit_cnt.sum(compr)*xi - bit_x.sum(compr)
        bit_x.add(compr, xi)
        bit_cnt.add(compr, 1)

    print(res)


if __name__ == '__main__':
    main()
