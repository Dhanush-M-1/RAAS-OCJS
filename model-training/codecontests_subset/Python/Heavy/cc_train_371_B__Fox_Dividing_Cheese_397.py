# import sys
# sys.stdin  = open("input.in","r")
from heapq import heapify,heappush,heappop
from collections import defaultdict as dd, deque as dq,Counter as C
from math import factorial as f ,ceil,gcd,sqrt,log
from itertools import permutations as p
from bisect import bisect_left as bl ,bisect_right as br
# def fibo_n(n):
# 	return (((1+sqrt(5))/2)**n)/sqrt(5)
# # import os,io
# # input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
from sys import stdin,stdout
input = stdin.readline
from bisect import bisect_right as bl
mp = lambda : map(int,input().split())
it = lambda: int(input())
def sev():
	mx = 2*(10**5) +5
	sv = [1]*(mx+1)
	sv[0]=sv[1]=0
	for i in range(2,mx):
		if i*i<=mx and sv[i]:
			for j in range(i*2,mx,i):
				sv[j]=0
	return sv
# d = dd(lambda : [])
def pfactors(n):
	d = dd(lambda : 0)
	flg =0
	while n%2==0:
		flg +=1
		n//=2
	if flg:
		d[2]= flg
	for cc in range(3,6,2):
		if n%cc==0:
			cnt =0
			while n%cc==0:
				cnt+=1
				n//=cc
			d[cc]=cnt
	return d,n
a,b = mp()
a1,rm1 = pfactors(a)
a2,rm2 = pfactors(b)
if rm1 == rm2:
	ans = abs(a1[2]-a2[2]) +  abs(a1[3]-a2[3]) + abs(a1[5]-a2[5])
	print(ans)
else:
	print(-1)


