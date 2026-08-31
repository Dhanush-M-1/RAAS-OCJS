n,m = map(int,input().split())
resp = 0

while n >= m:
	resp = resp + m
	n = n - m
	n = n + 1

resp = resp + n
print(resp)