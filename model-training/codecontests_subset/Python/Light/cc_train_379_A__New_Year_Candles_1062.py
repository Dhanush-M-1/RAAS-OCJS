a, b = map(int, input().split())
ans = 0
tt = a 
while a >= b:
	m = a // b
	ans += m
	t = a % b
	a = m + t
print(ans + tt)