import sys,math
from collections import deque
#input = sys.stdin.buffer.readline


def solve():	
	return;


# for _ in range(int(input())):
# 	solve()


[a,b] = input().split()

n = int(input())

for i in range(n):
	print(a,b)
	[x,y] = input().split()
	if x==a:
		a = y
	else:
		b = y

print(a,b)

