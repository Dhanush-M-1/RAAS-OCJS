import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log
from collections import defaultdict as dd
from bisect import bisect_left as bl, bisect_right as br
from collections import Counter
from collections import defaultdict as dd

#sys.setrecursionlimit(100000000)

inp = lambda: int(input())
strng = lambda: input().strip()
jn = lambda x, l: x.join(map(str, l))
strl = lambda: list(input().strip())
mul = lambda: map(int, input().strip().split())
mulf = lambda: map(float, input().strip().split())
seq = lambda: list(map(int, input().strip().split()))

ceil = lambda x: int(x) if (x == int(x)) else int(x) + 1
ceildiv = lambda x, d: x // d if (x % d == 0) else x // d + 1

flush = lambda: stdout.flush()
stdstr = lambda: stdin.readline()
stdint = lambda: int(stdin.readline())
stdpr = lambda x: stdout.write(str(x))
stdarr = lambda: map(int, stdstr().split())

mod = 1000000007


for _ in range(stdint()):
    n = stdint()

    matrix = []

    for __ in range(n):
        row = input()
        matrix.append(row)

    m1 = ["S01"+("x"*(n-3)), "01"+("x"*(n-2)), "1"+("x"*(n-1))]
    m2 = ["S10" + ("x" * (n - 3)), "10" + ("x" * (n - 2)), "0" + ("x" * (n - 1))]

    points = dd(list)

    d1 = []
    for i in range(3):
        for j in range(3):
            if(m1[i][j] != "x"):
                if(m1[i][j] != matrix[i][j]):
                    d1.append((i+1, j+1))

    d2 = []
    for i in range(3):
        for j in range(3):
            if(m2[i][j] != "x"):
                if(m2[i][j] != matrix[i][j]):
                    d2.append((i+1, j+1))


    if(len(d1) <= 2):
        print(len(d1))
        for i in d1:
            print(*i)

    else:
        print(len(d2))
        for i in d2:
            print(*i)
