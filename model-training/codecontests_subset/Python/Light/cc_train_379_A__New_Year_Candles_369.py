import sys
from copy import copy

a, b = map(int, input().split())
t = 0
p = 0

while 1:
	t += a
	p += a
	a = 0
	if p // b == 0: break
	a += p // b
	p -= (p // b)*b

print(t)
