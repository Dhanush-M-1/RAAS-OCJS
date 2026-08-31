from functools import lru_cache
from sys import stdin, stdout
import sys
from math import *

# from collections import deque
# sys.setrecursionlimit(int(2e5))
input = stdin.readline
# print = stdout.write
# dp=[-1]*100000

for __ in range(int(input())):
	n=int(input())
	ar=list(map(int,input().split()))
	x=0
	y=n-1
	ans=[]
	while(x+1<y):
		if(ar[x]+ar[x+1]<=ar[y]):
			ans=[x+1,x+2,y+1]
			break
		x+=1
		y-=1
	if(len(ans)==0):
		print(-1)
	else:
		print(*ans)

