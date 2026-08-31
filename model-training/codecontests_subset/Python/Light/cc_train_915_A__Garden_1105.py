#! /usr/bin/python3

n,k = map(int, input().split())

ans = k

for x in input().split():
	a = int(x)
	if k % a == 0:
		ans = min(k//a, ans)

print(ans)


