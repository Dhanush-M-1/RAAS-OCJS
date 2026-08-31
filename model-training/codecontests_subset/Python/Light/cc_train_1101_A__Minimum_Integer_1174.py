n = int(input())
for _ in range(n):
	l,r,d = map(int,input().split())
	i = r//d
	j = l//d
	if j > 0 and l!= d:
		print(d)
	else:
		print(d*i+d)   