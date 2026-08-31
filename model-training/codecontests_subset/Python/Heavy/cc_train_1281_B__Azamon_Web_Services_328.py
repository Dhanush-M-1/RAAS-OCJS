# rambo_1

from math import *
from copy import *
from string import *				# alpha = ascii_lowercase
from sys import stdin
from sys import maxsize
from operator import *				# d = sorted(d.items(), key=itemgetter(1))
from itertools import *
from collections import Counter		# d = dict(Counter(l))
from collections import defaultdict # d = defaultdict(list)

'''
3
AZAMON APPLE
AZAMON AAAAAAAAAAALIBABA
APPLE BANANA

AAMNOZ
AZAMON
true: IUWWWWWWUUUUUUWZ
mine: ---
'''

def solve(s1,s2):
	if(s1 < s2):
		return s1
	l1 = list(s1)
	sl1 = sorted(list(s1))
	f = 0
	for i in range(len(s1)):
		if(s1[i] != sl1[i]):
			for j in range(len(s1)-1,i,-1):
				if(s1[j] == sl1[i]):
					l1[j],l1[i] = l1[i],l1[j]
					f = 1
					break
		if(f == 1):
			break
	news1 = ''.join(l1)
	if(news1 < s2):
		return news1
	else:
		return '---'

T = int(input())
for _ in range(T):
	s1,s2 = map(str, stdin.readline().rstrip().split())
	print(solve(s1,s2))