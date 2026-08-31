# coding: utf-8
# Your code here!
import sys, collections, bisect, math, itertools, heapq
from fractions import gcd 
#input = sys.stdin.readline #文字列入力のときは注意

n,k,q = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
aa = sorted(a)
a += [0]

ans = 10**9+1
mmm = 0
for i,m in enumerate(aa):
#    print(i,m)
    if mmm == m: continue
    hh = [] 
    mae = 0
    for j,aj in enumerate(a):
        if aj < m:
            h=a[mae:j]
#            print(h,"h",j,mae)
            heapq.heapify(h)
            for _ in range(j-mae-k+1):
                hh.append(heapq.heappop(h))
            mae = j+1
    mmm = m
    
#    print("hh",hh)
    if len(hh) < q: break
    else:
        hh.sort()
        ans = min(ans, hh[q-1]-hh[0])
            
print(ans)
        


