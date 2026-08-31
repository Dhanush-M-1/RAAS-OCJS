import sys
import math,bisect
from collections import defaultdict
from itertools import groupby,accumulate
from heapq import heapify,heappop,heappush
from collections import deque,Counter,OrderedDict
#input = iter(sys.stdin.buffer.read().decode().splitlines()).__next__
def neo(): return map(int,input().split())
def Neo(): return list(map(int,input().split()))
for _ in range(int(input())):
    N,M = neo()
    A = Neo()
    B = Neo()
    f = 0
    Ans = 0
    for i in A:
        for j in B:
            if i == j:
                f = 1
                Ans = i
                break
        if f == 1:
            break        
    if f == 1:
        print('YES')
        print(1,Ans)
    else:
        print("NO")
