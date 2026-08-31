from sys import stdin, stdout, setrecursionlimit
from collections import deque, defaultdict, Counter
import math

rl = lambda: stdin.readline()
rll = lambda: stdin.readline().split()
rli = lambda: map(int, stdin.readline().split())
rlf = lambda: map(float, stdin.readline().split())

INF, NINF = float('inf'), float('-inf')

def solv(n):
	upperlim = 10**9+10
	Q = deque()
	seen = defaultdict(lambda: False)
	layer = 0
	Q.appendleft(n)
	while Q:
		for _ in range(len(Q)):
			curr = Q.pop()
			if seen[curr]: continue
			seen[curr] = True
			if curr == 1:
				return layer
			a = 2*curr
			if a <= upperlim and not seen[a]:
				Q.appendleft(a)
			if curr % 6 == 0 and not seen[curr//6]:
				Q.appendleft(curr//6)
		layer += 1
	return -1

def main():
	T = int(rl())
	for _ in range(T):
		n = int(rl())
		print(solv(n))
	stdout.close()

if __name__ == "__main__":
	main()