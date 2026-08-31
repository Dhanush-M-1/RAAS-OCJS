from sys import stdin, stdout, setrecursionlimit
from collections import deque, defaultdict, Counter
from heapq import heappush, heappop
import math

rl = lambda: stdin.readline()
rll = lambda: stdin.readline().split()
rli = lambda: map(int, stdin.readline().split())
rlf = lambda: map(float, stdin.readline().split())

INF, NINF = float('inf'), float('-inf')

def main():
	n, k = rli()
	both, alice, bob = [], [], []
	for _ in range(n):
		t, a, b = rli()
		if a and b:
			both.append(t)
		elif a:
			alice.append(t)
		elif b:
			bob.append(t)
	both.sort(reverse = True)
	alice.sort(reverse = True)
	bob.sort(reverse = True)
	read, time = 0, 0
	while read < k and (alice or bob or both):
		a = alice[-1] if alice else INF 
		b = bob[-1] if bob else INF 
		bo = both[-1] if both else INF 
		if a + b == INF and bo == INF: break
		if a + b <= bo:
			time += a + b
			alice.pop()
			bob.pop()
		else:
			time += bo 
			both.pop()
		read += 1
	print(time if read == k else -1)
	stdout.close()

if __name__ == "__main__":
	main()