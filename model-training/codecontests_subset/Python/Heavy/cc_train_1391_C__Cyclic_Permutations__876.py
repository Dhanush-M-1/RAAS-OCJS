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

n = int(input())
mod = 10**9 + 7
two = 1
prod = 1
for i in range(1,n+1):
	prod*=i
	prod%=mod
for i in range(1,n):
	two*=2
	two%=mod
print((prod - two)%mod)





