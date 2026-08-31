# not necessary to use a heap but hey why not, I needed a refresher
from heapq import *
n, k = [int(x) for x in input().split()]
alice = []
bob = []
both = []
for _ in range(n):
	t, a, b = [int(x) for x in input().split()]
	if a and b:
		heappush(both, t)
	elif a:
		heappush(alice, t)
	elif b:
		heappush(bob, t)
while len(alice) and len(bob):
	heappush(both, heappop(alice) + heappop(bob))
if len(both) < k:
	print(-1)
else:
	time = 0
	for _ in range(k):
		time += heappop(both)
	print(time)