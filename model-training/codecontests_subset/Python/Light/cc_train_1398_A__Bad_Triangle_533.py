t=int(input())
while t:
	t-=1
	b=int(input())
	a=input().split(" ")
	if int(a[0])+int(a[1])>int(a[-1]):
		print(-1)
	else:
		print(1,2,b)