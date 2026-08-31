import sys
import math
import collections
import heapq
input=sys.stdin.readline
r1,r2=(int(i) for i in input().split())
c1,c2=(int(i) for i in input().split())
d1,d2=(int(i) for i in input().split())
c3=0
for i in range(1,10):
    b=r1-i
    c=c1-i
    d=d1-i
    if(len(set([i,b,c,d]))==4 and max(i,b,c,d)<=9 and min(i,b,c,d)>=1 and b+c==d2 and c+d==r2 and b+d==c2):
        print(i,b)
        print(c,d)
        c3=1
        break
if(c3==0):
    print(-1)