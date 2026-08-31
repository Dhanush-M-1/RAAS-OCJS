t=int(input())
for i in range(t):
	n=int(input())
	l=list(map(int,input().split()))
	f=0
	
	for j in range(2,n):
		if l[0]+l[1]<=l[j]:
			print(1,2,j+1,sep=' ')
			f=1
			break
	if f==0:
		print(-1)
		
	