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


t=fi()
while t>0:
	t-=1
	n=fi()
	c=d=0
	while n%2==0:
		n//=2
		c+=1
	while n%3==0:
		n//=3
		d+=1
	if n!=1 or d<c:
		print(-1)
		continue
	print(d+(d-c))	
