import sys
input=sys.stdin.readline
from collections import defaultdict as dc
from collections import Counter
from bisect import bisect_right, bisect_left
import math
from operator import itemgetter
from heapq import heapify, heappop, heappush
from queue import PriorityQueue as pq
for _ in range(int(input())):
    l,r,d=map(int,input().split())
    x,y=l//d,r//d
    if l>d:
        print(d)
    else:
        print((y+1)*d)