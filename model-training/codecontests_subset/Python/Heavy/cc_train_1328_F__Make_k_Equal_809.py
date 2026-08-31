n, k = map(int, input().split())
a = list(map(int, input().split()))
d = {}
for i in a:
	d[i] = d.get(i, 0) + 1
if max(d.values()) >= k:
	print(0)
	exit()
a = sorted(a)
d = max(a)
b = [0] * (d + 1)
dp = [0] * (d + 1)
for _ in range(n):
	i = a[_]
	if b[i] >= k:
		continue
	b[i] += 1
	tc = 0
	while i != 0:
		if b[i // 2] >= k:
			i //= 2
		else:
			tc += 1
			b[i // 2] += 1
			dp[i // 2] += tc
			i //= 2
ans = 1431132213123133123213213231323
for i in range(1, d + 1):
	if b[i] >= k:
		ans = min(ans, dp[i])
print(ans)
