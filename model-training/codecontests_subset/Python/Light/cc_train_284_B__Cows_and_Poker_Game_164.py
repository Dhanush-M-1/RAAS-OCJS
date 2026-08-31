from collections import deque, defaultdict, Counter
from itertools import product, groupby, permutations, combinations
from math import gcd, floor, inf
from bisect import bisect_right, bisect_left

n = int(input())
s = input()
ans = 0
ii = s.count("I")
aa = s.count("A")
if ii > 1:
    print(0)
    exit()
elif ii == 0:
    print(aa)
else:
    print(1)
    








