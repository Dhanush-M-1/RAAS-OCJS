t=int(input())
for _ in range(t):
	n=int(input())
	l=list(map(int,input().split()))
	flag=0
	if(len(l)<=2):
		print(-1)
	else:
		for i in range(n-1):
			if(l[i]+l[i+1]<=l[-1]):
				flag=1
				ans=i+1
				ans1=i+2
				ans3=n
				break
		if(flag==0):
			print(-1)
		else:
			print(ans,ans1,ans3)