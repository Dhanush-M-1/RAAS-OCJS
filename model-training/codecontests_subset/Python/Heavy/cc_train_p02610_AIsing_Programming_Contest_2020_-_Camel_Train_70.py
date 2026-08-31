T = int(input())

import heapq

def calc(camels):
	camels.sort()
	camels.reverse()
	count = len(camels)
	
	score = 0
	queue = []
	i = 0
	for k in range(count, 0, -1):
		while i < count and camels[i][0] >= k:
			K, L, R = camels[i]
			heapq.heappush(queue, (-(L - R), L, R))
			i += 1
		if len(queue) > 0:
			D, L, R = heapq.heappop(queue)
			score += L
	while len(queue) > 0:
		D, L, R = heapq.heappop(queue)
		score += R
	while i < count:
		K, L, R = camels[i]
		score += R
		i += 1
	return score

for t in range(T):
	N = int(input())
	
	camels_l = []
	camels_r = []
	
	count_r = 0
	for _ in range(N):
		K, L, R = map(int, input().split())
		if L - R >= 0:
			camels_l.append((K, L, R))
		else:
			camels_r.append((N - K, R, L))
	
	print(calc(camels_l) + calc(camels_r))
