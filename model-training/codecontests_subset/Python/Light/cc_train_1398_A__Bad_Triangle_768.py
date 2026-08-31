t = int(input())

while (t):

	n = int(input())
	a = input().split()
	a = list(map(int,a))
	if (a[0]+a[1] <= a[-1]):	
		print(1,2,n)
	else:	
		print(-1)

	t -= 1