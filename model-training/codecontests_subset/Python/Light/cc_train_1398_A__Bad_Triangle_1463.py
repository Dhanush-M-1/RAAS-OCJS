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
    N = int(input())
    A = Neo()
    if A[0]+A[1] > A[-1]:
        print(-1)
    else:
        print(1,2,N)
    
		