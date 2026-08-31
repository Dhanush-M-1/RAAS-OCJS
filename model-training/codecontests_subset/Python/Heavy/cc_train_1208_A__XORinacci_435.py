# ANSHUL GAUTAM
# IIIT-D

from math import *
from copy import *
from string import *				# alpha = ascii_lowercase
from random import *
from sys import stdin
from sys import maxsize
from operator import *				# d = sorted(d.items(), key=itemgetter(1))
from itertools import *
from collections import Counter		# d = dict(Counter(l))

'''
3
3 4 2
4 5 0
325 265 1231232
'''

def solve(a,b,n):
	if(n == 0):
		return a
	elif(n == 1):
		return b
	else:
		if(n%3 == 0):
			return a
		elif(n%3 == 1):
			return b
		else:
			return a^b


T = int(input())
for _ in range(T):
	a,b,n = map(int, stdin.readline().rstrip().split())
	print(solve(a,b,n))