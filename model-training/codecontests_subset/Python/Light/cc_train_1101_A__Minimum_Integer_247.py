import sys
input=sys.stdin.buffer.readline
import os
from math import*


t=int(input())
while t:
	t-=1
	l,r,d=map(int,input().split())
	if d<l:
		print(d)
	else:
		if r%d==0:
			print(r+d)
		else:
			print(r+d-(r%d))