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
	n , m = map(int , input().split())
	a = list(map(int , input().split()))
	b = list(map(int , input().split()))
	ans = []
	for i in a:
		if i in b:
			ans.append(i)
			break
		if len(ans)==1:
			break
	if len(ans) == 0:
		print("NO")
	else:
		print("YES")
		print(1, ans[0])







