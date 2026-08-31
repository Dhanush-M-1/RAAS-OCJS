import math
from decimal import Decimal
import heapq
import copy
import heapq
from collections import deque
def na():
	n = int(input())
	b = [int(x) for x in input().split()]
	return n,b
 
	
def nab():
	n = int(input())
	b = [int(x) for x in input().split()]
	c = [int(x) for x in input().split()]
	return n,b,c
 
		
def dv():
	n, m = map(int, input().split())
	return n,m
 
 
def da():
	n, m = map(int, input().split())
	a = list(map(int, input().split()))
	return n,m, a 
 
 
def dva():
	
	n, m = map(int, input().split())
	a = [int(x) for x in input().split()]
	b = [int(x) for x in input().split()]
	return n,m,b
 
 
def eratosthenes(n): 
	sieve = list(range(n + 1))
	for i in sieve:
		if i > 1:
			for j in range(i + i, len(sieve), i):
				sieve[j] = 0
	return sorted(set(sieve))
 
 
def lol(lst,k):
	k=k%len(lst)
	ret=[0]*len(lst)
	for i in range(len(lst)):
		if i+k<len(lst) and i+k>=0:
			ret[i]=lst[i+k]
		if i+k>=len(lst):
			ret[i]=lst[i+k-len(lst)]
		if i+k<0:
			ret[i]=lst[i+k+len(lst)]
	return(ret)
def nm():
	n = int(input())
	b = [int(x) for x in input().split()]
	m = int(input())
	c = [int(x) for x in input().split()]
	return n,b,m,c
 
 
def dvs():
	n = int(input())
	m = int(input())
	return n, m 
 
 
def fact(n):
	tc = []
	ans = {}
	d = 2
	while d * d <= n:
		if n % d == 0:
			tc.append(d)
			n //= d
		else:
			d += 1
	if n > 1:
		tc.append(n)
	for i in tc:
		ans[i] = ans.get(i, 0) + 1
	return ans


def how_many(l, r, c):
	m = (l + r) // 2
	if r - l == 1:
		if s[l] == c:
			return 0
		else:
			return 1
	d = s[l:m]
	k1 = (r - l) // 2 - s[l:m].count(c) + how_many(m, r, chr(ord(c) + 1))
	k2 = (r - l) // 2 - s[m:r].count(c) + how_many(l, m, chr(ord(c) + 1))
	return min(k1, k2)
 
for _ in range(int(input())):
		n, m = map(int, input().split())
		a = list(map(int, input().split()))
		b = list(map(int, input().split()))
		ans = -1
		for i in range(n):
			for j in range(m):
				if a[i] == b[j]:
					ans = a[i]
					break
			if ans != -1:
				break
		if ans != -1:
			print('YES')
			print(1, ans)
		else:
			print('NO')
