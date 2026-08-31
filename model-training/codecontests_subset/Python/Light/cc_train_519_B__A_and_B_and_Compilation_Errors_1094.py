# import sys
# sys.stdin = open("#input.txt", "r")
n = int(input())
f = sorted([int(x) for x in input().split()])
s = sorted([int(x) for x in input().split()]) + [0]
t = sorted([int(x) for x in input().split()]) + [0,0]
f1 = f2 = False
for i in range(n):
	if not f1 and f[i] != s[i]:
		f1 = f[i]
	if not f2 and s[i] != t[i]:
		f2 = s[i]
	if f1 and f2:
		break
print(f1)
print(f2)