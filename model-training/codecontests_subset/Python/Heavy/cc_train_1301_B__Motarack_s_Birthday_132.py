for t in range(int(input())):
	n=int(input())
	arr = list(map(int,input().split()))
	prev=-1
	k=-1
	diff=-1
	minimum=9999999999999999999999
	maximum=-1
	for i in range(n):
		if arr[i]==-1:
			if i!=0 and arr[i-1]!=-1:
				minimum=min(minimum,arr[i-1])
				maximum=max(maximum,arr[i-1])
			if i!=n-1 and arr[i+1]!=-1:
				minimum=min(minimum,arr[i+1])
				maximum=max(maximum,arr[i+1])

	if maximum==-1:
		print(0,0)
	else:
		# print(minimum,maximum)
		k1=(maximum+minimum)//2

		diff1 = -1
		if arr[0]==-1:
			arr[0]=k1
		for i in range(1,n):
			if arr[i]==-1:
				arr[i]=k1
			diff1=max(diff1,abs(arr[i]-arr[i-1]))
		
		k2=(maximum+minimum)//2
		k2+=1

		diff2 = -1
		if arr[0]==-1:
			arr[0]=k2
		for i in range(1,n):
			if arr[i]==-1:
				arr[i]=k2
			diff2=max(diff2,abs(arr[i]-arr[i-1]))
		if diff2<diff1:
			print(diff2,k2)
		else:
			print(diff1,k1)

			


