import sys
import math
import bisect
from sys import stdin, stdout
from math import gcd, floor, sqrt, log
from collections import defaultdict as dd
from bisect import bisect_left as bl, bisect_right as br
from collections import Counter

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
stdstr = lambda: stdin.readline().rstrip()
stdint = lambda: int(stdin.readline())
stdpr = lambda x: stdout.write(str(x))
stdarr = lambda: map(int, stdstr().split())

mod = 1000000007

for _ in range(stdint()):
    n,m = stdarr()

    s = stdstr()
    p = list(stdarr())

    c = Counter()

    pref = [0]*(n)

    for i in range(m):
        pref[p[i]-1]+= 1

    suffSum = [0]*n

    for i in range(n-1, 0, -1):
            pref[i-1] += pref[i]

    for i in range(n):
        c[s[i]] += pref[i]+1

    for i in range(ord('a'), ord('z')+1):
        print(c[chr(i)], end=" ")

    print()
