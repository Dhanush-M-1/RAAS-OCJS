import bisect
t=int(input())
for i in range(t):
	n,m=map(int,input().split())
	a=list(map(int,input().split()))
	x=list(map(int,input().split()))
	pre=[0]*n
	pre[0]=a[0]
	cur=a[0]
	for j in range(1,n):
		cur+=a[j]
		pre[j]=max(cur,pre[j-1])
 
	ans=[0]*m
	for j in range(m):
		if cur<=0:
			if pre[-1]<x[j]:
				ans[j]=-1
			else:
				ans[j]=bisect.bisect_left(pre,x[j])
		else:
			if pre[-1]<x[j]:
				req=x[j]-pre[-1]
				d=(req)//cur
				if req%cur:
					d+=1
				x[j]-=(d*cur)
				ans[j]=n*d
 
			ans[j]+=bisect.bisect_left(pre,x[j])
 
	print(*ans)