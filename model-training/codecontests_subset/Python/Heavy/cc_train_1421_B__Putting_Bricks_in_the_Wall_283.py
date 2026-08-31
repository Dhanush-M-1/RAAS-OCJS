import sys
from random import *
#from bisect import *
#from collections import deque
pl=1
#from math import *
from copy import *

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

		
t=fi()
while t>0:
	t-=1
	n=fi()
	a=[]
	for i in range(n):
		a.append(si())
	p=a[0][1]
	q=a[1][0]
	r=a[n-1][n-2]
	s=a[n-2][n-1]
	ans=[]
	if len(set([p,q]))==1:
		
			if r==p:
				ans.append([n,n-1])
			if 	s==p:
				ans.append([n-1,n])
	elif len(set([r,s]))==1:
		if r==p:
				ans.append([1,2])
		if 	s==q:
				ans.append([2,1])
	else:
		if p=="0":
			ans.append([1,2])
		if q=="0":
			ans.append([2,1])	
		if r=='1':
				ans.append([n,n-1])
		if 	s=='1':
				ans.append([n-1,n])	
	print(len(ans))
	for i in ans:
		print(*i)	