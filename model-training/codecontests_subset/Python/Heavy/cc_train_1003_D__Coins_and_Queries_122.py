import copy
import sys

input = sys.stdin.readline

BITS = 32

a = input().split(" ")
n = int(a[0])
q = int(a[1])

v = [int(i) for i in input().split(" ")]
cnt = [0 for i in range(BITS)]

for i in v:
	for j in range(BITS):
		if (1 << j) == i:
			cnt[j] += 1
			break

res = []
for lgmoorz in range(q):

	cv = int(input())
	
	ok = True
	ans = 0
	csum = 0

	for j in range(BITS - 1, -1, -1):
		currpow = 1 << j
		canfit = (cv - csum) // currpow
		toadd = min(canfit, cnt[j])
		ans += toadd
		csum += toadd * currpow

	if csum == cv:
		res.append(ans)
	else:
		res.append(-1)


for j in res:
	sys.stdout.write(str(j) + "\n")
