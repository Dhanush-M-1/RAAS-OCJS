t=int(input())
for i in range(t):
	n=int(input())
	k=list(map(int,input().split()))
	a,b,c=0,1,n-1
	if((k[a]+k[b])>k[c]):
		print(-1)
	else:
		print(a+1,b+1,c+1)