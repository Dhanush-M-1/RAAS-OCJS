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
	arr = list(map(int , input().split()))
	if arr[0] + arr[1] > arr[n-1]:
		print(-1)
	else:
		print(1,2,n)







