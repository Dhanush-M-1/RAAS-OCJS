import sys
#input=sys.stdin.readline
from collections import defaultdict as dc
from collections import Counter
from bisect import bisect_right, bisect_left
import math
from operator import itemgetter
from heapq import heapify, heappop, heappush
n=int(input())
l=list(map(int,input().split()))
o,e,p,q=0,0,[],[]
for i in l:
    if i%2:
        o+=1
        p.append(i)
    else:
        e+=1
        q.append(i)
if abs(o-e)<=1:
    print(0)
else:
    if o>e:
        p.sort()
        print(sum(p[:o-e-1]))
    else:
        q.sort()
        print(sum(q[:e-o-1]))