import os, sys, math
import collections


#res = solve('(R' + ('(R)R' * 2) + ')')

if os.path.exists('testing'):
	name = os.path.basename(__file__)
	if name.endswith('.py'):
		name = name[:-3]
	src = open(name + '.in.txt', encoding='utf8')
	input = src.readline

def solve(a, b, c):
	bc_count = min(b, c // 2)
	b -= bc_count
	ab_count = min(a, b // 2)
	return (ab_count + bc_count) * 3

n = int(input().strip())
for _ in range(n):
	a, b, c = map(int, input().strip().split())
	r = solve(a, b, c)
	print(r)
