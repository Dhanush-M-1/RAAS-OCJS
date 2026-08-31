a,b=list(map(str,input().split()))
k=int(input())
print(a,b)
for i in range(k):
	g,d=list(map(str,input().split()))
	if g==a:
		g=b
		print(g,d)
		
	else:
		g=a
		print(g,d)
	a=g
	b=d
