'''input
1000000007
'''
# A coding delight
from sys import stdin, stdout
import gc
from copy import deepcopy
from itertools import permutations
gc.disable()
input = stdin.readline
import math


def get_time(x, i):
	count = 0
	while x > 0 and x % i == 0:
		x //= i 
		count += 1
	return count


def get_min_max(subset):
	num = 1
	for i in subset:
		num *= i ** divisor[i]
	return max(num, x // num)


def get_prime():
	mx = 10 ** 6 + 1
	prime = []
	seive = [1] * (mx)
	for i in range(2, mx ):
		if seive[i] == 1:
			prime.append(i)
			for j in range(i * i , mx, i):
				seive[j] = 0
	return prime



# main starts
x = int(input().strip())
if x == 1:
	print(1, 1)
	exit()
prime = get_prime()
divisor = dict()
for i in prime:
	if x % i == 0:
		divisor[i] = get_time(x, i)

l = []		
for i in divisor:
	l.append(i)
# print(divisor)
if len(l) == 0:
	print(1, x)
	exit()
ans = float('inf')
for i in range(1, 2 ** len(l)):
	subset = []
	for k in range(len(l)):
		if 1 << k & i:
			subset.append(l[k])
	ans = min(ans, get_min_max(subset))

print(ans, x//ans)




