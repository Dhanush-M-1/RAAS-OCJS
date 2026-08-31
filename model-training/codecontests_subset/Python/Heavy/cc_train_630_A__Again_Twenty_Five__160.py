from sys import stdin,stdout
from collections import Counter
from math import ceil
from bisect import bisect_left 
from bisect import bisect_right
import math

ai = lambda: list(map(int, stdin.readline().split()))
ei = lambda: map(int, stdin.readline().split())
ip = lambda: int(stdin.readline().strip())

M = 100
def modularExponentiation(x,n,M):
	if n==0:
		return 1
	elif n%2==0:
		return modularExponentiation((x*x)%M,n//2,M)
	else:
		return (x*modularExponentiation((x*x)%M,(n-1)//2,M))%M


n = ip()
x = str(int(modularExponentiation(5,n,M)))

print(x[-2:])