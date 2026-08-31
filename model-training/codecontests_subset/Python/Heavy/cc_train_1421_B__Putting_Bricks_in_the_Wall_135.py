import sys, math
import io, os
#data = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from bisect import bisect_left as bl, bisect_right as br, insort
from heapq import heapify, heappush, heappop
from collections import defaultdict as dd, deque, Counter
#from itertools import permutations,combinations
def data(): return sys.stdin.readline().strip()
def mdata(): return list(map(int, data().split()))
def outl(var) : sys.stdout.write('\n'.join(map(str, var))+'\n')
def out(var) : sys.stdout.write(str(var)+'\n')
#from decimal import Decimal
#from fractions import Fraction
#sys.setrecursionlimit(100000)
INF = float('inf')
mod=10**9+7


for t in range(int(data())):
    n=int(data())
    mat=[data() for i in range(n)]
    cnt=0
    if mat[0][1]!='0':
        cnt+=1
    if mat[0][2]!='1':
        cnt+=1
    if mat[1][0]!='0':
        cnt+=1
    if mat[1][1]!='1':
        cnt+=1
    if mat[2][0]!='1':
        cnt+=1
    if cnt<3:
        print(cnt)
        if mat[0][1] != '0':
            print(1,2)
        if mat[0][2] != '1':
            print(1,3)
        if mat[1][0] != '0':
            print(2,1)
        if mat[1][1] != '1':
            print(2,2)
        if mat[2][0] != '1':
            print(3,1)
        continue
    cnt = 0
    if mat[0][1] != '1':
        cnt += 1
    if mat[0][2] != '0':
        cnt += 1
    if mat[1][0] != '1':
        cnt += 1
    if mat[1][1] != '0':
        cnt += 1
    if mat[2][0] != '0':
        cnt += 1
    if cnt < 3:
        print(cnt)
        if mat[0][1] != '1':
            print(1, 2)
        if mat[0][2] != '0':
            print(1, 3)
        if mat[1][0] != '1':
            print(2, 1)
        if mat[1][1] != '0':
            print(2, 2)
        if mat[2][0] != '0':
            print(3, 1)
        continue
