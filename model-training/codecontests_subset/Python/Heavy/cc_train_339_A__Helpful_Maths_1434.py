from math import pi, gcd, factorial
from collections import defaultdict, Counter
from heapq import heapify, heappop, heappush
from sys import maxsize
mod1 = 10**(-9)
mod1 = (10**9) + 7

########################### Input #############################
def input_t():
	return int(input())

def input_f():
	return float(input())

def input_list():
	return [int(num) for num in input().split()]

########################## Output #############################
def print_c(i, res):
	print("Case {}: {}".format(i+1, res))

def print_e(i, res):
	print("Case {} = {}".format(i+1, res))

########################## Tarminate #########################
def max_min():
	return (maxsize, -maxsize-1)

def tar(a, b, c):
	if a == b == c == 0:
		exit()
##############################################################

def solve():
	# for t in range(input_t()):
		s = input()
		d = Counter(s)
		res = ""
		for ch in ("1", "2", "3"):
			res += ch*d[ch]
		print("+".join(c for c in res))

if __name__=="__main__":
	solve()