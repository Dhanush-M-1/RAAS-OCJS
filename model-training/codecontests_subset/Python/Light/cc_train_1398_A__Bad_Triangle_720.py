from collections import defaultdict as dd
import math
import sys
import string
input=sys.stdin.readline
def nn():
	return int(input())

def li():
	return list(input())

def mi():
	return map(int, input().split())

def lm():
	return list(map(int, input().split()))


def solve():

	n = nn()

	lens = lm()

	if lens[0]+lens[1]<=lens[n-1]:
		print(1,2,n)
		return

	print(-1)
	return



q=nn()

for _ in range(q):
	solve()
