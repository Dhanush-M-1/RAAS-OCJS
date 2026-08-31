'''input
5 10
0 0 0 1 2
2 1 0 0 0
'''
# A coding delight
from sys import stdin


def get_x(first, second):
	if first <= second:
		return second - first
	else:
		return m - first + second


def check(first, second):
	x = get_x(first, second)
	aux = arr[:]
	for i in range(n):
		aux[i] += x
		aux[i] %= m
	aux.sort()
	return aux == barr



# main starts
n, m = list(map(int, stdin.readline().split()))
arr = list(map(int, stdin.readline().split()))
barr = list(map(int, stdin.readline().split()))

barr.sort()

ans = float('inf')
for i in range(n):
	if check(arr[i], barr[0]):
		ans = min(ans, get_x(arr[i], barr[0]))
		# print(ans)
print(ans)