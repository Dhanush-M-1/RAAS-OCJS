import math
t=int(input())
for tt in range(t):
	n=int(input())
	arr=list(map(int,input().split()))
	start=0
	end=int(1e9)
	mm=1e9
	anss=-1
	while start<=end:
		mid=(start+end)//2
		mid1=(mid-1)
		mid2=(mid+1)
		ans=-1
		for i in range(1,n):
			a=arr[i-1]
			b=arr[i]
			if a==-1:
				a=mid 
			if b==-1:
				b=mid
			ans=max(ans,abs(a-b))
		ans1=0
		for i in range(1,n):
			a=arr[i-1]
			b=arr[i]
			if a==-1:
				a=mid1 
			if b==-1:
				b=mid1
			ans1=max(ans1,abs(a-b))
		ans2=-1
		for i in range(1,n):
			a=arr[i-1]
			b=arr[i]
			if a==-1:
				a=mid2 
			if b==-1:
				b=mid2
			ans2=max(ans2,abs(a-b))
		if ans1==-1:
			ans1=int(1e15)
		if ans2==-1:
			ans2=int(1e15)
		if ans==-1:
			ans=int(1e15)
		# if ans!=-1:
			# mm=min(ans,mm)
		if mm>ans:
			mm=ans
			anss=mid
		# if ans1!=-1:
			# mm=min(ans1,mm)
		if mm>ans1:
			mm=ans1 
			anss=mid1
		# if ans2!=-1:
			# mm=min(ans2,mm)
		if mm>ans2:
			mm=ans2
			anss=mid2
		if ans2<ans1:
			start=mid+1
		else:
			end=mid-1
		# if ans1
	print(mm,anss)
