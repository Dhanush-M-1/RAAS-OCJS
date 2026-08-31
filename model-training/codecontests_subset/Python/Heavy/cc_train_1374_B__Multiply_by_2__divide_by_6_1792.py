# ANSHUL GAUTAM
# IIIT-D

from math import *
from copy import *					# ll = deepcopy(l)
from heapq import *					# heappush(hp,x)
from string import *				# alpha = ascii_lowercase
from random import *				# l.sort(key=lambda l1:l1[0]-l1[1]) => ex: sort on the basis difference
from bisect import *				# bisect_left(arr,x,start,end)  => start and end parameters are temporary
from sys import stdin				# bisect_left return leftmost position where x should be inserted to keep sorted
from sys import maxsize				# minn = -maxsize
from operator import *				# d = sorted(d.items(), key=itemgetter(1))
from itertools import *				# pre = [0] + list(accumulate(l))
from decimal import Decimal 		# a = Decimal(a)	# use this for math questions
from collections import Counter		# d = dict(Counter(l))
from collections import defaultdict # d = defaultdict(list)

'''
7
1
2
3
12
12345
15116544
387420489
'''

def solve(n):
	if(n == 1):
		return 0
	ans = 0
	while(n != 1):
		if(n%3 != 0):
			return -1
		elif(n%6 == 0):
			n //= 6
		else:
			n *= 2
		ans += 1
	return ans
	

T = int(input())
for _ in range(T):
	N = int(stdin.readline())
	print(solve(N))

