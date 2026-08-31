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
	n, x, y = map(int, input().split())
	s = input()
	n = str(s)
	n = n[len(s) - x:]
	ny =  '0' * max((x - y - 1), 0) + str(10 ** y)
	count = 0
	# print(ny)
	# print(n)
	for i in range(x):
		if n[i] != ny[i]:
			count += 1
	print(count)

if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()







