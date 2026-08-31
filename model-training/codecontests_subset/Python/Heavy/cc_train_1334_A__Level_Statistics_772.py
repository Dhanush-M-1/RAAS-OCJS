# ANSHUL GAUTAM
# IIIT-D

from math import *
from copy import *
from string import *				# alpha = ascii_lowercase
from random import *				# l.sort(key=lambda l1:l1[0]-l1[1]) => ex: sort on the basis difference
from bisect import *				# bisect_left(arr,x,start,end)  => start and end parameters are temporary
from sys import stdin				# bisect_left return leftmost position where x should be inserted to keep sorted
from sys import maxsize
from operator import *				# d = sorted(d.items(), key=itemgetter(1))
from itertools import *
from collections import Counter		# d = dict(Counter(l))
from collections import defaultdict # d = defaultdict(list)

'''
6
3
0 0
1 1
1 2
2
1 0
1000 3
4
10 1
15 2
10 2
15 2
1
765 432
2
4 4
4 3
5
0 0
1 0
1 0
1 0
1 0
'''

def solve(L):
	n = len(L)
	f = 1
	diff = L[0][0] - L[0][1]
	if(diff < 0):
		f = 0
	else:
		for i in range(1,n):
			currDiff = L[i][0] - L[i][1]
			if(currDiff < 0 or currDiff < diff):
				f = 0
				break
			else:
				diff = currDiff
			# plays/clears decrease
			if(L[i][0] < L[i-1][0] or L[i][1] < L[i-1][1]):
				f = 0
				break
			# constant plays
			if(L[i][0] == L[i-1][0] and L[i][1] != L[i-1][1]):
				f = 0
				break

	return 'YES' if(f) else 'NO'

T = int(input())
for _ in range(T):
	N = int(stdin.readline())
	L = []
	for nn in range(N):
		l = list(map(int, stdin.readline().rstrip().split()))
		L.append(l)
	print(solve(L))
