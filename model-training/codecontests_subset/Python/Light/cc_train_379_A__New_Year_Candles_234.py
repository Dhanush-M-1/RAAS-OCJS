n, k = map(int, input().split())
ans = n
r = 0
while(n > 0):
	n = n + r
	r = n % k
	n = n // k
	ans = ans + n
	
print(ans)
