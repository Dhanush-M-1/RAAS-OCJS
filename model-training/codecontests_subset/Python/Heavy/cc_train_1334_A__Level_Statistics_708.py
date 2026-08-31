#import math
#from functools import lru_cache
#import heapq
#from collections import defaultdict
#from collections import Counter
#from sys import stdout
#from sys import setrecursionlimit
from sys import stdin
input = stdin.readline
for ti in range(int(input().strip())):
    n = int(input().strip())
    pp, cp = -1, -1
    valid = True
    for ni in range(n):
        pi, ci = [int(x) for x in input().strip().split()]
        if((pi-pp)<(ci-cp) or pi<pp or ci<cp):
            valid = False
        pp, cp = pi, ci
    if not valid:
        print('No')
    else:
        print('Yes')
