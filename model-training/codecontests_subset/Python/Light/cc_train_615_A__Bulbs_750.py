#!/usr/bin/python3

(n, m) = tuple(map(int, input().split()))

on = set()

for i in range(n):
	bulbs = list(map(int, input().split()))
	bulbs.pop(0)
	on = on | set(bulbs)

if len(on) == m:
	print("YES")
else:
	print("NO")