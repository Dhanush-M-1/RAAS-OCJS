from collections import deque, defaultdict, Counter
from itertools import product, groupby, permutations, combinations
from math import gcd, floor, inf
from bisect import bisect_right, bisect_left

r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
rr = r1+r2
cc = c1+c2
dd = d1+d2
mn = min(r1, r2, c1, c2, d1, d2)
mx = max(r1, r2, c1, c2, d1, d2)
if (rr ++ cc)/2 != dd or mn < 3 or mx > 17:
    print(-1)
else:
    top_left = (dd - d2 - r2 + c1)//2
    top_right = r1 - top_left
    bottom_left = c1 - top_left
    bottom_right = r2 - bottom_left
    st = {top_left, top_right, bottom_left, bottom_right}
    mn = min(st)
    mx = max(st)
    if len(st) != 4 or mn < 1 or mx > 9:
        print(-1)
    else:
        print(top_left, top_right)
        print(bottom_left, bottom_right)


