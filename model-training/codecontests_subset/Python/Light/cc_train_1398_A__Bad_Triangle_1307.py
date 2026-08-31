from collections import defaultdict
t=int(input())

for _ in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	mi=a[0]
	mx=a[n-1]
	flag=0
	for i in range(1,n-1):
		if(a[i]<=mx-mi):
			print(1,i+1,n)
			flag=1
			break
	if(flag==0):
		print(-1)
