for _ in range(int(input())):
	a,b,c = map(int,input().split())
	if c<a or c>b:print(c)
	else:z = b//c +1;print(c*z)