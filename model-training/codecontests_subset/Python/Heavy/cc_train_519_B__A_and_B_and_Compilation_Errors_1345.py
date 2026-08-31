import sys
#import bisect
import math
#import itertools
def get_line(): return list(map(int,sys.stdin.readline().strip().split()))
def in1(): return int(input())

n=in1()
a=get_line()
b=get_line()
c=get_line()
a.sort()
b.sort()
c.sort()
t1=-1
t2=-1
for i in range(len(c)):
        if b[i]!=c[i] and t2==-1:
            t2=b[i]
        if a[i]!=b[i] and t1==-1:
            t1=a[i]
        if t2!=-1 and t1!=-1:
            break
if t1==-1:
    if a[n-2]!=b[n-2]:
        t1=a[n-2]
    else:
        t1=a[n-1]
if t2==-1:
    t2=b[len(c)]
print(t1)
print(t2)