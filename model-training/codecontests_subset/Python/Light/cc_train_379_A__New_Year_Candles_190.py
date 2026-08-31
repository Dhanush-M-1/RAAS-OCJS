a, b = map(int, input().split())
ans = 0
for i in range(1, a + 1):
	ans += 1
	if ans % b == 0:
		ans += 1
print(ans)
		

