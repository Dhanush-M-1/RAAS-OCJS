#: Author - Soumya Saurav
import sys,io,os,time
from collections import defaultdict
from collections import OrderedDict
from collections import deque
from itertools import combinations
from itertools import permutations
import bisect,math,heapq
alphabet = "abcdefghijklmnopqrstuvwxyz"

input = sys.stdin.readline

########################################

for ii in range(int(input())):
	n = int(input())
	ans = 0
	if n == 1:
		print(0)
		continue
	curr = 0
	f = 1
	two = 0
	three = 0
	while n%2 == 0:
		#print("n  :",n)
		n = n // 2
		two += 1
	while n%3 == 0:
		#print("n  :",n)
		n = n//3
		three+=1
	#print("2 3 : ",two , three)
	if n != 1:
		print(-1); continue
	if three < two:
		print(-1)
	else:
		print(three + (three - two))
	
		







