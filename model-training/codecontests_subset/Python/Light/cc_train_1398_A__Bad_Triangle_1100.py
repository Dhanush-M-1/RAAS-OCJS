
t=int(input())
for i in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	c=0
	if(a[0]+a[1]>a[n-1]):
		c+=1
	if(a[n-1]+a[0]>a[1]):
		c+=1
	if(a[n-1]+a[1]>a[0]):
		c+=1
	if(c==3):
		print("-1")
	else:
		print(1,2,n)

