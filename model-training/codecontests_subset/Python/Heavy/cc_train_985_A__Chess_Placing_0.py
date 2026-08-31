import re
import math
import decimal
import bisect

def read():
	return input().strip()

n = int(read())
ps = [0 for i in range(1, n+1)]
nadd = 10
for x in sorted([int(_) for _ in read().split()]):
	ps[x-1] = nadd
	nadd += 10
nadd = 15
for i, p in enumerate(ps):
	if p == 0:
		ps[i] = nadd
		nadd += 10

# print(ps)
swapped = True
swapsA = 0
workps = ps[:]
while swapped:
	swapped = False
	for i in range(n-1):
		if workps[i] > workps[i+1]:
			tmp = workps[i]
			workps[i] = workps[i+1]
			workps[i+1] = tmp
			swapsA += 1
			swapped = True
# print(ps, swapsA)

for i, p in enumerate(ps):
	if p % 10 == 5:
		ps[i] -= 10

swapped = True
swapsB = 0
workps = ps[:]
while swapped:
	swapped = False
	for i in range(n-1):
		if workps[i] > workps[i+1]:
			tmp = workps[i]
			workps[i] = workps[i+1]
			workps[i+1] = tmp
			swapsB += 1
			swapped = True

# print(ps, swapsB)
print(min(swapsA, swapsB))
