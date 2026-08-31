from functools import lru_cache
from sys import stdin, stdout
import sys
from math import *

# from collections import deque
# sys.setrecursionlimit(int(1e3))
# input = stdin.buffer.readline
# print = stdout.write

for __ in range(int(input())):
	n,m=map(int,input().split())
	a=list(map(int,input().split()))
	b=list(map(int,input().split()))
	d={}
	ans=False
	rslt=-1
	for i in range(n):
		d[a[i]]=1
	for i in range(m):
		if(d.get(b[i])!=None):
			ans=True
			rslt=b[i]
			break
	if(ans):
		print("YES")
		print(1,rslt)
	else:
		print("NO")