n=int(input())
arr=list(map(int,input().split()))
ans=0
for i in range(len(arr)):
	ans=max(ans,min(arr[i]-1,1000000-arr[i]))
print(ans)