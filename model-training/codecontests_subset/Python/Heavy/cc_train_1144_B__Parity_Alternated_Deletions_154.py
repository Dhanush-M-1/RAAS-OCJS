import math
from collections import defaultdict, Counter, deque


def primeFactor(n):
	if n % 2 == 0:
		return 2
	i = 3
	while (i ** 2) <= n:
		if n % i == 0:
			return i 
		i += 1
	return n


def main():
	n = int(input())
	arr = list(map(int, input().split()))

	even = []
	odd = []
	for i in range(n):
		if arr[i] % 2 == 0:
			even.append(arr[i])
		else:
			odd.append(arr[i])

	even.sort(reverse=True)
	odd.sort(reverse=True)

	if len(even) > len(odd):
		f = even
		s = odd
	else:
		f = odd
		s = even

	diff = len(f) - len(s) - 1
	# print(diff)
	if diff <= 0:
		print(0)
		return 
	else:
		print(sum(f[-diff::1])) 

	 

if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()







