t=int(input())
for tt in range(t):
	n=int(input())
	arr=list(map(int,input().split()))
	flag=False
	for i in range(n-1):
		start=i+2
		end=n-1
		ss=arr[i]+arr[i+1]
		ans=-1
		while start<=end:
			mid=(start+end)//2
			if ss<=arr[mid]:
				ans=mid
				end=mid-1
				# break
			else:
				start=mid+1
		if ans!=-1:
			flag=True
			print(i+1,i+2,ans+1)
			break
	if flag==False:
		print(-1)