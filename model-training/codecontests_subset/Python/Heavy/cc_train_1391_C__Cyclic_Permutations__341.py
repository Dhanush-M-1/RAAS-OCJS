'''input
4
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

def power( x, y, p): 
    res = 1 # Initialize result  
    x = x % p # Update x if it is more than  
              # or equal to p  
    while (y > 0) :  
          
        # If y is odd, multiply x with result  
        if (y & 1) : 
            res = (res * x) % p  
  
        # y must be even now  
        y = y >> 1 # y = y/2  
        x = (x * x) % p  
  
    return res  

def modFact(n, p): 
    if n >= p: 
        return 0    
  
    result = 1
    for i in range(1, n + 1): 
        result = (result * i) % p  
  
    return result 

# print(modFact(3, 10**9+7))

# for _ in range(0, int(input())):
n=int(input())                                 # Single Digit Input
	# n, k = map(int, input().strip().split())    # Many Digit Input
	# l=list(map(int, input().strip().split()))      # List Input
	# s=list(input())                                # Character Array Input

print((modFact(n, (10 ** 9 + 7))-(power(2, n-1, 10 ** 9 + 7)))%(10**9+7))