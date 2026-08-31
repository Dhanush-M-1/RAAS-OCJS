# from functools import lru_cache
from sys import stdin, stdout
import sys
from math import *
# from collections import deque
# sys.setrecursionlimit(3*int(1e5))
# input = stdin.buffer.readline
# print = stdout.write
 
# @lru_cache()

n,k=map(int,input().split())
a=[]
bt=[]
b=[]

for i in range(n):
	x,y,z=map(int,input().split())
	if(y==z==1):
		bt.append(x)
	elif(y==1):
		a.append(x)
	elif(z==1):
		b.append(x)
a.sort()
bt.sort()
b.sort()
ans=inf
for i in range(1,len(a)):
	a[i]=a[i]+a[i-1]
for i in range(1,len(b)):
	b[i]=b[i]+b[i-1]
for i in range(1,len(bt)):
	bt[i]+=bt[i-1]

y=min(len(bt),k)

while(y>=0):
	x=min(len(a),len(b),k-y-1)
	# print(y,x)
	if(x==-1):
		ans=min(ans,bt[y-1])
	elif(y==0 and x<len(a) and x<len(b)):
		ans=min(ans,a[x]+b[x])
	elif(y+x+1==k and x<len(a) and x<len(b)):
		ans=min(ans,bt[y-1]+a[x]+b[x])
	y-=1
	# elif(x+y)
if(ans==inf):
	print(-1)
else:
	print(ans)