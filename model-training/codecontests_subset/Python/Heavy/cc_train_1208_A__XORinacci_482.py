'''input
3
3 4 2
4 5 0
325 265 1231232

'''
import sys
from collections import defaultdict as dd
from itertools import  permutations as pp
from itertools import combinations as cc
from collections import Counter as ccd
from random import randint as rd
from bisect import bisect_left as bl
from  heapq import heappush as hpush
from heapq import heappop as hpop
mod=10**9+7

def ri(flag=0):
	if flag==0:
		return [int(i) for i in sys.stdin.readline().split()]
	else:
		return int(sys.stdin.readline())


def f(n):
	if n==0:
		return a
	if n==1:
		return b
	else:
		return f(n-1)^f(n-2)


for _ in range(ri(1)):
	a,b,n=ri()
	take=[a,b]


	if n%3==0:
		print(a)
	if n%3==1:
		print(b)
	if (n%3==2):
		print(a^b)