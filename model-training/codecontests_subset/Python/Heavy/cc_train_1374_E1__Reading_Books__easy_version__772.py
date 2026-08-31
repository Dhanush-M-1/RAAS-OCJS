import sys
from collections import defaultdict as dd
from collections import deque
from fractions import Fraction as f
from copy import *
from bisect import *	
from heapq import *
from math import *
from itertools import permutations 
 
def eprint(*args):
    print(*args, file=sys.stderr)
zz=1
 
#sys.setrecursionlimit(10**6)
if zz:
	input=sys.stdin.readline
else:	
	sys.stdin=open('input.txt', 'r')
	sys.stdout=open('all.txt','w')
def li():
	return [int(x) for x in input().split()]
def fi():
	return int(input())
def si():
	return list(input().rstrip())	
def mi():
	return 	map(int,input().split())	
def gh():
	sys.stdout.flush()
def graph(n,m):
	for i in range(m):
		x,y=mi()
		a[x].append(y)
		a[y].append(x)
def bo(i):
	return ord(i)-ord('a')


n,k=mi()
a=[]
for i in range(n):
	p=li()
	a.append(p)
a.sort()

c=d=ans=0
c1=[]
d1=[]
r=0
#print(a)
for i in range(n):
	if a[i][1:]==[0,1]:
		if d+r>=k:
			continue
		ans+=a[i][0]
		d1.append(a[i][0])
		d+=1

	elif a[i][1:]==[1,0]:
		if c+r>=k:
			continue
		ans+=a[i][0]
		c1.append(a[i][0])
		c+=1

	elif a[i][1:]==[1,1]:
		
		#ans+=a[i][0]
		

		if c+r>=k and d+r>=k and len(c1)+len(d1)>1:
			#print("lol")
			if c1[-1]+d1[-1]>a[i][0]:
				#print("LOL",ans)
				r+=1
				c-=1
				d-=1
				ans-=(c1[-1]+d1[-1])
				ans+=a[i][0]
				c1.pop()
				d1.pop()
				continue
		if c+r<k or d+r<k:
			r+=1
			ans+=a[i][0]		
		if c+r>k:
			ans-=c1[-1]
			c-=1
			c1.pop()
			#ans+=a[i][0]
		if d+r>k:
			ans-=d1[-1]
			d-=1
			d1.pop()
			#ans+=a[i][0]

	if r>=k:
		break		
	#print(c+r,d+r,r,ans,c1,d1)	
	
print(ans if c+r>=k and d+r>=k else -1)				
