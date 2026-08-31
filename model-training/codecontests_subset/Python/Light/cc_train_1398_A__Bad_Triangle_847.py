t=int(input())
for _ in range(t):
	n=int(input())
	ar=list(map(int,input().split()))
	a=ar[0]
	b=ar[1]
	c=ar[-1]
	if c>=a+b:
		print(1,2,n)
	else:
		print(-1)
