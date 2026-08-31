#!/bin/python3
import math; import os; import random; import re; import sys
from collections import defaultdict, Counter, deque
import heapq
from functools import lru_cache
from itertools import accumulate, chain, combinations, permutations, groupby, zip_longest
from math import floor, ceil, sqrt

L = int(input())
arr = list(map(int, input().split()))
if len(arr)==1:
	print(1, 1)
	print(0)
	print(1, 1)
	print(0)
	print(1, 1)
	print(-arr[0])

else:
	print(' '.join(map(str, [1, L-1])))
	add = [(arr[i]%L)*(L-1) for i in range(L-1)]
	print(' '.join(map(str, add)))
	for i in range(L-1):
		arr[i] += add[i]

	print(' '.join(map(str, [L, L])))
	print(-1*(arr[-1]%L))
	arr[-1] += -1*(arr[-1]%L)

	print(' '.join(map(str, [1, L])))
	print(' '.join(map(str, [-v for v in arr])))




























