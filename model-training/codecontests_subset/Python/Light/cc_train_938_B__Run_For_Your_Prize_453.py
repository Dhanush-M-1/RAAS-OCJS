n=int(input())
a=list(map(int,input().split()))

ans=1
for i in range(n):
	if a[i]<=500000:
		ans=a[i]-1
	else:
		ans=max(ans,1000000-a[i])
		break
print(ans)