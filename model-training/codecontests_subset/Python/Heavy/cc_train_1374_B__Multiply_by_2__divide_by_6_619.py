#from statistics import median
#import collections
#aa = collections.Counter(a) # list to list || .most_common(2)で最大の2個とりだせるお a[0][0]
from fractions import gcd
from itertools import combinations,permutations,accumulate # (string,3) 3回
#from collections import deque
from collections import deque,defaultdict,Counter
import decimal
import re
#import bisect
#
#    d = m - k[i] - k[j]
#    if kk[bisect.bisect_right(kk,d) - 1] == d:
#
#
#
# pythonで無理なときは、pypyでやると正解するかも！！
#
#

import sys
sys.setrecursionlimit(10000000)
mod = 10**9 + 7
#mod = 9982443453
def readInts():
  return list(map(int,input().split()))
def I():
  return int(input())

for _ in range(I()):
    n = I()
    if n == 1:
        print(0)
    elif n%3 != 0:
        print(-1)
    else:
        two = 0
        three = 0
        while n%3 == 0:
            three += 1
            n //= 3
        if n%2 == 0:
            while n%2 == 0:
                two += 1
                n //= 2
        if n != 1:
            print(-1)
        else:
            if two <= three:
                print(three*2 - two)
            else:
                print(-1)
