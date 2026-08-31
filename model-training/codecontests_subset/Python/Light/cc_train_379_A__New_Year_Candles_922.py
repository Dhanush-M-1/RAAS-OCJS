n,k=map(int,input().split())
ans=n
while n//k>0:
	ans+=n//k
	n=n//k+n%k
print(ans)
