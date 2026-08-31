def answ():
	x=int(input())
	s=list(map(int,input().split()))

	a=s[0]
	b=s[1]
	for n in range(x-1,1,-1):
		c=s[n]
		if a+b<=c or a+c<=b or b+c<=a:
			print(1,2,n+1)
			return
	b=s[-1]
	for n in range(x-2,0,-1):
		c=s[n]
		if a+b<=c or a+c<=b or b+c<=a:
			print(1,n+1,x)
			return
	print(-1)


for i in range(int(input())):
	answ()
