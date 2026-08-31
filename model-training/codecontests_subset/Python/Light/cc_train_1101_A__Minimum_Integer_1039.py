for _ in range(int(input())):
	l,r,d = map(int,input().split())
	i = d
	if l<=i<=r:
		mul = r//i
		i = i*(mul+1)

	print(i)