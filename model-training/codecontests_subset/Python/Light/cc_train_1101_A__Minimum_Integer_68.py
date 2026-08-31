n = int(input())
for i in range(n) :
	a,b,c = map(int,input().split())

	if(a / c > 1) :
		print(c)
	else :
		print(((b//c)+1) *c )
	
