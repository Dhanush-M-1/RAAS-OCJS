from functools import lru_cache
from sys import stdin, stdout
import sys
# from math import *
def noOfPermutations(a, n,mod): 

	if (n == 1): 
		return 1
	a.sort() 
	if (a[n - 1] == a[n - 2]): 
		return 0

	x = 0
	for i in range( n - 2): 
 
		if (a[i] == a[i + 1]): 

			if (a[i] == a[i + 2]): 
				return 0
		
			x += 1
			i += 1

	return pow(2, n - 2 * x - 1,mod) 


n=int(input())
a=[i+1 for i in range(n)]
mod=1000000007
num = noOfPermutations(a, n,mod) 
f=1
for i in range(2,n+1):
	f=(f*i)%mod
# print(f)
print((f-num)%mod)


					
