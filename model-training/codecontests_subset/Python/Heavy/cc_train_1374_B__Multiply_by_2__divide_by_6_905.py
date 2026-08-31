import math
import bisect
import sys
from collections import OrderedDict
input = sys.stdin.readline
def inp():
	return(int(input()))
def inlt():
	return(list(map(int,input().split())))
def insr():
	s = input()
	return(s[:len(s)-1])
def invr():
	return(map(int,input().split()))
# N, M = inlt()
# A = inlt()
T = inp()
# MOD = 1000000007
# print(MOD)
for t in range(T):
	N = inp()
	two = 0
	three = 0
	while N%2 == 0:
		two += 1
		N= N//2
	while N%3 == 0:
		three += 1
		N = N//3
	if N != 1:
		print(-1)
	else:
		if two > three:
			print(-1)
		else:
			print(two+((three-two)*2))