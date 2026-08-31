N, M = map(int, input().split())
b = [False]*M
r = M
for n in range(N):
	X = [int(x)-1 for x in input().split()]
	for x in X[1:]:
		if not b[x]:
			r -= 1
			b[x] = True
print("NO" if r else "YES")
