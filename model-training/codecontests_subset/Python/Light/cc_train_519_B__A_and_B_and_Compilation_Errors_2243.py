from sys import stdin
input=lambda : stdin.readline().strip()
from math import ceil,sqrt,factorial
INT_MIN=float("-infinity")
INT_MAX=float("infinity")
n=int(input())
l=list(map(int,input().split()))
d={}
z={}
for i in l:
	if i in d:
		d[i]+=1
	else:
		d[i]=1
for i in list(map(int,input().split())):
	if i in z:
		z[i]+=1
	else:
		z[i]=1
	d[i]-=1
for i in d:
	if d[i]>0:
		print(i)
		break
for i in list(map(int,input().split())):
	z[i]-=1
for i in z:
	if z[i]>0:
		print(i)
		break
