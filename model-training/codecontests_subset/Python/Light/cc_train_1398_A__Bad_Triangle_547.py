for i in range(int(input())):
	g = input()
	a = [0] + list(map(int, input().split()))
	
	if a[1] + a[2] <= a[-1]:
		print(1, 2, g)
	else:
		print(-1)