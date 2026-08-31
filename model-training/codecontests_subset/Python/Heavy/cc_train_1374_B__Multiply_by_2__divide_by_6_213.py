
# MasterKali

from sys import stdin
from collections import Counter
from math import sqrt, factorial, log10, log, floor, ceil
from itertools import permutations, combinations, combinations_with_replacement

input = stdin.readline
def li(): return list(map(int, input().split()))
def lis(): return list(map(str, input().split()))
def mp(): return map(int, input().split())
def inp(): return int(input())
def inps(): return str(input().strip())
def pr(n): return stdout.write(str(n)+"\n")

INF = float('inf')


def solve():
	n = inp()
	if n == 1: return 0
	if n == 2 or n%5==0: return -1
	k, cnt = 0, 0
	while (n!=1):
		if n%6==0:
			n//=6
		else:
			x = n%6
			if x==2: cnt+=1
			if x == 2 and cnt == 2:
				return -1
			n*=2
		if n == 2:
			return -1
		k+=1		

	return k


t = inp()
for i in range(t):
	print(solve())

