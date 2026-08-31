# import math
# import bisect
import sys
# from collections import Counter
input = sys.stdin.readline
def inp():
	return(int(input()))
def inlt():
	return(list(map(int,input().split())))
def insr():
	s = input()
	return(s[:len(s)-1])
def invr():
	return(map(int,input().split()))
def print_fract(p,q):
	g = math.gcd(p,q)
	p//=g
	q//=g
	print(str(p)+"/"+str(q))
# n = 583291
p = 1000000007
def fn(n,modulus):
	ans0 = 1
	ans1 = 1
	for i in range(1,(n+1) // 2):
		ans0 = ans0 * (2*i + 0) % modulus    
		ans1 = ans1 * (2*i + 1) % modulus    

	return ans0 * ans1 % modulus
def power(x, y, p) : 
	res = 1 
	x = x % p  
	if (x == 0) : 
		return 0
	while (y > 0) : 
		if ((y & 1) == 1) : 
			res = (res * x) % p
		y = y >> 1       
		x = (x * x) % p 
	return res
n = inp()
a= fn(n,p)
if n%2 == 0:
	a*=n
	a = a%p
print((a-power(2,n-1,p))%p) 
