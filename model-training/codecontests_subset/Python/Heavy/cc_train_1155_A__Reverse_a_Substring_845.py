import sys
input=sys.stdin.readline
from collections import defaultdict as dc
from collections import Counter
from bisect import bisect_right, bisect_left
import math
from operator import itemgetter
from heapq import heapify, heappop, heappush
n=int(input())
s=list(input()[:-1])
x=dc(list)
if len(set(s))==1:
    print("NO")
else:
    for i in range(n):
        x[s[i]].append(i)
    p="abcdefghijklmnopqrstuvwxyz"
    f=0
    k=-1
    for i in range(n):
        for j in range(ord(s[i])-ord('a')):
            if x[p[j]]:
                k=bisect_left(x[p[j]],i)
                if k!=len(x[p[j]]):
                    k=x[p[j]][k]
                    f=1
                    break
            if f==1:
                break
        if f==1:
            break
    if f==0:
        print("NO")
    else:
        print("YES")
        print(i+1,k+1)
'''
l=[1,2,3,5]
print(bisect_left(l,6))
'''
