import math
from decimal import Decimal
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
def Factor(n):
	Ans = []
	d = 2
	while d * d <= n:
		if n % d == 0:
			Ans.append(d)
			n //= d
		else:
			d += 1
	if n > 1:
		Ans.append(n)
	return Ans


def fact(a, b):
	c = []
	ans = 0
	f = int(math.sqrt(a))
	for i in range(1, f + 1):
		if a % i == 0:
			c.append(i)
	l = len(c)
	for i in range(l):
		c.append(a // c[i])
	for i in range(len(c)):
		if c[i] <= b:
			ans += 1
	if a / f == f and b >= f:
		return ans - 1
	return ans


n, p , w, d = map(int, input().split())
x = -1
y = -1
for i in range(w):
	if (p - d * i) % w == 0:
		y = i
		x = (p - i * d) // w
		break
if y < 0 or x + y > n or x < 0:
	print(-1)
else:
	print(x, y, n - x - y)
