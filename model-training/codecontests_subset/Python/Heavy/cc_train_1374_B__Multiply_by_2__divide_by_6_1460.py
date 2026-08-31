import sys
# from collections import deque
# from collections import Counter
# from math import sqrt
from math import log
# from math import ceil
# from bisect import bisect_left, bisect_right

# alpha=['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
# mod=10**9+7
# mod=998244353

# def BinarySearch(a,x): 
# 	i=bisect_left(a,x) 
# 	if(i!=len(a) and a[i]==x): 
# 		return i 
# 	else: 
# 		return -1

# def sieve(n): 
# 	prime=[True for i in range(n+1)]
# 	p=2
# 	while(p*p<=n): 
# 		if (prime[p]==True): 
# 			for i in range(p*p,n+1,p): 
# 				prime[i]=False
# 		p+=1
# 	prime[0]=False
# 	prime[1]=False
# 	s=set()
# 	for i in range(len(prime)):
# 		if(prime[i]):
# 		s.add(i)
# 	return s

# def gcd(a, b):
# 	if(a==0):
# 		return b 
# 	return gcd(b%a,a)

fast_reader=sys.stdin.readline
fast_writer=sys.stdout.write

def input():
	return fast_reader().strip()

def print(*argv):
	fast_writer(' '.join((str(i)) for i in argv))
	fast_writer('\n')

#____________________________________________________________________________________________________________________________________

for _ in range(int(input())):
	n=int(input())
	if(n==1):
		print(0)
	elif(n%3!=0):
		print(-1)
	else:
		temp=n
		c3=0
		while(temp%3==0):
			temp=temp//3
			c3+=1
		c2=0
		while(temp%2==0):
			temp=temp//2
			c2+=1
		if(temp!=1 or c3<c2):
			print(-1)
		else:
			print(c3+c3-c2)