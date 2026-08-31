# import sys
# sys.stdin = open("#input.txt", "r")
n,m = map(int, input().split())

lights = [False]*m

for _ in range(n):
	__,*ls = map(int, input().split())
	for i in ls: lights[i-1] = True

print("NYOE S"[all(lights)::2])