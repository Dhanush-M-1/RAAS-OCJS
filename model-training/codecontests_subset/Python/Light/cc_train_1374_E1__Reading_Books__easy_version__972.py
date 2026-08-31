import sys
input = sys.stdin.readline

n, k = map(int, input().split())
B = [tuple(map(int, input().split())) for _ in range(n)]

FB = []
AB = []
BB = []

for t, a, b in B:
	if a and b:
		FB.append(t)
	elif a:
		AB.append(t)
	elif b:
		BB.append(t)

AB.sort()
BB.sort()
for t1, t2 in zip(AB, BB):
	FB.append(t1+t2)

FB.sort()

if len(FB) < k:
	print(-1)
else:
	print(sum(FB[:k]))
