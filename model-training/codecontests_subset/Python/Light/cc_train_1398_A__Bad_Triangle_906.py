from sys import stdin,stdout
from collections import Counter
from math import ceil
from bisect import bisect_left 
from bisect import bisect_right
import math

ai = lambda: list(map(int, stdin.readline().split()))
ei = lambda: map(int, stdin.readline().split())
ip = lambda: int(stdin.readline().strip())

for i in range(ip()):
	n = ip()
	li = ai()
	if (li[0]+li[1]) <= li[-1]:
		print(1,2,n)
	else:
		print(-1)