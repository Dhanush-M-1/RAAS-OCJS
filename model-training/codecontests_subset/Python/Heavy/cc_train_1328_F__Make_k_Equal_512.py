import sys
from collections import defaultdict as dd
def eprint(*args):
    print(*args, file=sys.stderr)
zz=1
from math import *
import copy
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

def bo(i):
	return ord(i)-ord('a')

n,k=mi()
a=li()
a.sort()
pre=[0]*(n+1)
suf=[0]*(n+1)
d=dd(lambda:0)
vis=dd(lambda:0)
for i in range(n):
	pre[i]+=pre[i-1]+a[i]
	d[a[i]]+=1
for i in range(n-1,-1,-1):
	suf[i]=suf[(i+1)%n]+a[i]
mini=10**18	
for i in range(n):
	if vis[a[i]]:
		continue
	p=k-d[a[i]]
	vis[a[i]]=1
	f=0
	if p<=0:
		mini=0
		break
	if i>=p:
		f=1
		c=(a[i]-1)*i-pre[i-1]
		c+=p
		mini=min(mini,c)
	if i+d[a[i]]>=n:
		continue	
	if n-i-d[a[i]]>=p:
			f=1
			z=n-i-d[a[i]]
			c=-(a[i]+1)*z+suf[i+d[a[i]]]
			c+=p
			mini=min(mini,c)
	if not f:
		z=n-i-d[a[i]]
		c=-(a[i]+1)*z+suf[i+d[a[i]]]+(a[i]-1)*i-pre[i-1]+p
		mini=min(mini,c)
	
print(mini)		
				
