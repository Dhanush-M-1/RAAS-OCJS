n, k = map(int, input().split())
a = list(map(int, input().split()))

ans = 1e9
for i in range(0, n):
	if k%a[i] == 0:
		ans = min(ans, k//a[i])
print(ans)