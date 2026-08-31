import sys
from math import sqrt, floor, factorial
from collections import deque, Counter
inp = sys.stdin.readline
read = lambda: list(map(int, inp().strip().split()))

def solve():
	n, m = read(); sett = set()
	for _ in range(n):
		sett.update(read()[1:])
	print("YNEOS"[(len(sett) != m)::2])



if __name__ == "__main__":
	solve()