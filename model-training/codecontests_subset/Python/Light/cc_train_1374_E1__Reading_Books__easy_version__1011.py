from sys import stdout
from collections import defaultdict
import math
'''t=int(input())
for _ in range(t):
    #n=int(input())
    n,k=map(int,input().split())
    l=list(map(int,input().split()))
    l.sort(reverse=True)'''
n,k=map(int,input().split())
l=list()
d=defaultdict(list)
for i in range(n):
    a,b,c=map(int,input().split())
    s=str(b)+str(c)
    d[s].append(a)
l1=sorted(d['11'])
l2=sorted(d['10'])
l3=sorted(d['01'])
ans=0
l4=list()
m=min(len(l2),len(l3))
for i in range(m):
    l4.append(l2[i]+l3[i])
l=sorted(l1+l4)
if len(l)<k:
    stdout.write(str(-1)+'\n')
else:
    print(sum(l[:k]))

                
    