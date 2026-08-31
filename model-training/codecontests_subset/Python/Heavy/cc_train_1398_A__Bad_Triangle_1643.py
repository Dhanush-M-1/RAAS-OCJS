'''input
3
7
4 6 11 11 15 18 20
4
10 10 10 11
3
1 1 1000000000
'''

import math
import sys
import itertools
import random
import bisect
import heapq
import collections

def lcm(x, y):
	return (x*y)//math.gcd(x,y)
def hcf(x, y):
	return math.gcd(x, y)
def primes(n):
	prime=[True for _ in range(0, n+1)]
	res=[]
	p=2
	while p*p<=n:
		if prime[p]==True:
			for i in range(p*p,n+1,p):
				prime[p]=False
		p+=1
	for i in range(0, n+1):
		if prime[i]==True:
			res.append(i)
	return res
def primeFactors(n):
	res=[]
	while n%2==0:
		res.append(2)
		n//=2
	for i in range(3, math.sqrt(n)+1, 2):
		while n%i==0:
			res.append(i)
			n//=i
	if n>2:
		res.append(n)
	return res


for _ in range(0, int(input())):
	n=int(input())                                 # Single Digit Input
	# n, k = map(int, input().strip().split())    # Many Digit Input
	l=list(map(int, input().strip().split()))      # List Input
	# s=list(input())                                # Character Array Input

	i = l[0]
	j = l[1]
	flag=0
	for ie in range(2, n):
		if l[ie]>=i+j:
			print(1, 2, ie+1)
			flag=1
			break
	if flag==0:
		print(-1)