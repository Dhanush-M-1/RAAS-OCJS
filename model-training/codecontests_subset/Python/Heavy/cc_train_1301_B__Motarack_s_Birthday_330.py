from __future__ import division 
import math 





T = int(input())


for case in range(T):
	N = int(input())
	arr = [int(x) for x in input().split()]

	cu = 0
	maxx = 0
	minn = 0
	n_maxx = 0
	neigh = []
	for pos in range(N):
		if arr[pos] == -1:
			for x in arr[pos - 1:pos] + arr[pos + 1: pos + 2]:
				if x != -1:
					neigh.append(x)
		else:
			if arr[min(pos + 1, N - 1)] != -1:
				if abs(arr[pos] - arr[min(pos + 1, N - 1)]) > n_maxx:
					n_maxx = abs(arr[pos] - arr[min(pos + 1, N - 1)])






	for n in range(len(neigh)):
		if n == 0:
			maxx = neigh[n]
			minn = neigh[n]
		else:
			if maxx < neigh[n]:
				maxx = neigh[n]
			elif minn > neigh[n]:
				minn = neigh[n]

	diff = maxx - minn
	k = int(math.ceil((maxx - minn)/2))
	print (max(k, n_maxx), k + minn)




