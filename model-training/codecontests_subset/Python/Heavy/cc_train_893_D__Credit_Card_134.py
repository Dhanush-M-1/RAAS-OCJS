import sys
from random import *
from bisect import *
#from collections import deque
pl=1
from math import gcd,sqrt
from copy import *
sys.setrecursionlimit(10**5)
if pl:
	input=sys.stdin.readline
else:	
	sys.stdin=open('input.txt', 'r')
	sys.stdout=open('outpt.txt','w')

def li():
	return [int(xxx) for xxx in input().split()]
def fi():
	return int(input())
def si():
	return list(input().rstrip())	
def mi():
	return 	map(int,input().split())	

		
t=1
ans=[]
time=flag=1
d={}
		
while t>0:
	t-=1
	n,d=mi()
	a=li()
	p=[]
	for i in range(n):
		if a[i]==0:
			p.append(i)
	c=ans=0
	nex=n
	r=[0]*n
	for i in range(len(p)-1,-1,-1):
		j=p[i]+1
		c=maxi=0
		while j<nex:
			c+=a[j]
			maxi=max(maxi,c)
			j+=1
		if i==len(p)-1:
			r[p[i]]=max(0,d-maxi)
		else:
			r[p[i]]=max(0,min(r[nex]-c,d-maxi))		
		nex=p[i]	

	c=0

	for i in range(n):
		if a[i]==0:
			if c<0:
				ans+=1
				c=r[i]
		else:
			c+=a[i]

		if c>d:
			print(-1)
			exit(0)
	print(ans)		