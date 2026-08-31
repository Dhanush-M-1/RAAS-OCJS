for _ in range(int(input())):
	n=int(input())
	a=[int(x) for x in input().split()]
	x=a[0]
	y=a[1]
	found=False
	for i in range(n-2):
		z=a[2+i]
		if(x+y<=z):
			found=True
			print(1,2,i+3)
			break
	if not found:print(-1)