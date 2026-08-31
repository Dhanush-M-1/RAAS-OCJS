def gcd(a,b): return math.gcd(a,b)
def lcm(a,b): return ((a*b)//math.gcd(a,b))
def ncr(n,r): return math.comb(n,r)
def npr(n,r): return (math.factorial(n)//math.factorial(n-r))

import sys, os.path
import math
from collections import defaultdict,deque

input = sys.stdin.readline

I = lambda : list(map(int,input().split()))
S = lambda : list(map(str,input1()))

def main():

	t,=I()
	for t1 in range(t):
		n, = I()
		a   = I()
		if n==1:
			print("Yes")
			continue
		else:
			left  = [False]*n
			right = [False]*n
			for i in range(n-1,-1,-1):
				if a[i]>=n-i-1:
					right[i] = True
				if i+1<n:
					right[i] = right[i+1] and right[i]

			for i in range(n):
				if a[i]>=i:
					left[i] = True
				if i-1>=0:
					left[i] = left[i-1] and left[i]
			count = 0
			for i in range(len(left)):
				if left[i] and right[i]:
					print("Yes")
					count = 1
					break	
			if count==0:
				print("No")
			# print(left)
			# print(right)


main()
