n=int(input())
for i in range(n):
	t=int(input())
	c=list(map(int,input().split()))
	g=c[0]+c[1]
	h=0
	for j in range(2,t):
		if(g<=c[j]):
			h=j
			break
	if(h!=0):
		print(1,end=" ")
		print(2,end=" ")
		print(h+1,end=" ")
		print()
	else:
		print(-1)