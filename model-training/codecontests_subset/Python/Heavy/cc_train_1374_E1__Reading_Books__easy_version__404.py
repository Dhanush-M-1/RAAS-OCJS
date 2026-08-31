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



n , k = map(int , input().split())
both = []
alice = []
bob = []
for i in range(n):
	x,y,z = map(int, input().split())
	if y and z:
		both.append(x)
	elif y:
		alice.append(x)
	elif z:
		bob.append(x)
alice.sort()
bob.sort()
for i in range(min(len(alice),len(bob))):
	both.append(alice[i]+bob[i])
both.sort()
if len(both)<k:
	print(-1)
else:
	print(sum(both[:k]))
