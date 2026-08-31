from math import ceil
from math import floor	
from math import sqrt
from math import log

prime = pow(10, 9) + 7

def mod_expo(n, p, m):
	"""find (n^p)%m"""
	result = 1
	while p != 0:
		if p%2 == 1:
			result = (result * n)%m
		p //= 2
		n = (n * n)%m
	return result
	
def are_same(arr, b):
	a1 = list()
	b1 = list()
	a1 = arr.copy()
	b1 = b.copy()
	a1.sort()
	b1.sort()
	return a1 == b1
	
def find_xmin(n, m, arr, b):
	mn = m
	if are_same(arr, b):
		return 0
	for i in range(n):
		x = (b[0] - arr[i])%m
		if x < 0:
			x += m
		c = []
		for j in range(n):
			c.append((arr[j] + x)%m)
		if are_same(c, b):
			mn = min(mn, x)
	return mn
		
		
	

t=1
#t=int(input())
while t:
	t = t - 1
	count=0
	# n, ox, oy = map(int, input().split())
	n, m = map(int, input().split())
	# text = input()
	# n = int(input())
	arr = list(map(int, input().strip().split()))[:n]
	b = list(map(int, input().strip().split()))[:n]
	# above = input()
	# below = input()
	print(find_xmin(n, m, arr, b))

	#a1, b1 = map(int, input().split())
	#a2, b2 = map(int, input().split())
	
	# print(a + g)
	
	# print(ffin(n, arr, b))
	#if is_square(a1, b1, a2, b2):
	# 	print("YES")
	#else:
	#	print("NO")
	#answers = find_given_gcd(n, k)
	#print(contest_function(n, arr))

	
