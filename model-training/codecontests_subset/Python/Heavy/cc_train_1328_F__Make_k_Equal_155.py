'''input
5 3
1 2 3 4 5
'''
from sys import stdin
from copy import deepcopy
from collections import deque, defaultdict


def get_arr(num):
	if num in freq:
		if len(freq[num]) >= k:
			return sum(freq[num][: k])
		else:
			return float('inf')
	else:
		return float('inf')
	



def get_min(arr):
	for i in freq:
		if freq[i] >= k:
			return 0
	return float('inf')


# main starts
n, k = list(map(int, stdin.readline().split()))
arr = list(map(int, stdin.readline().split()))
arr.sort()

freq = defaultdict(list)
for num in arr:
	count = 0
	while num > 0:
		freq[num].append(count)
		num //= 2
		count += 1
	freq[0].append(count)


# print(freq)

for i in freq:
	freq[i].sort()

ans = float('inf')
m = max(arr)
for i in range(0, m + 1):
	ans = min(ans, get_arr(i))
	
print(ans)
