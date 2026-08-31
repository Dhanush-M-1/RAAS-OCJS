# your code goes here
t=int(input())
for i in range(t):
	n=int(input())
	ar=list(map(int,input().split()))
	flg=0
	x=ar[0]
	y=ar[1]
	z=ar[n-1]
	if x+y<=z:
		print(1,2,n)
	else:
		print(-1)