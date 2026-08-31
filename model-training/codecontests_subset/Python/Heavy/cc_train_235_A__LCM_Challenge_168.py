import random, math
from copy import deepcopy as dc



def gcd(a, b):
	if b== 0:
		return a
	return gcd(b, a%b)

def lcm(a, b):
	return a * b // (gcd(a, b))

# Function to call the actual solution
def solution(n):
	if n <= 2:
		return n
	a = dc(n)
	if n % 2 != 0:
		b = dc(n - 1)
		c = dc(n - 2)
	elif gcd(n, n-3) == 1:
		b = n-1
		c = n - 3
	else:
		a = n - 1
		b = n - 2
		c = n - 3
	l = lcm(lcm(a,b), c)
	return l



# Function to take input
def input_test():
	n = int(input())
	out = solution(n)
	print(out)

# Function to check test my code
def test():
	pass

# seive()
input_test()
# test()