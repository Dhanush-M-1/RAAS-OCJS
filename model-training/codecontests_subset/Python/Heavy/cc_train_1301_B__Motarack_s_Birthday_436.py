
def check(l,x):
	ans=0
	for i in l:
		ans=max(ans,abs(i-x))
	return ans

for _ in range(int(input())):
	n=int(input())
	a=list(map(int,input().split()))

	minc=a.count(-1)

	if(minc==n):
		print(0,0)
	else:
		l=[]
		for i in range(n):
			if(i==0):
				if(a[i]!=-1 and a[i+1]==-1):
					l.append(a[i])
			elif(i==n-1):
				if(a[i]!=-1 and a[i-1]==-1):
					l.append(a[i])
			else:
				if(a[i]!=-1):
					if(a[i+1]==-1):
						l.append(a[i])
					if(a[i-1]==-1):
						l.append(a[i])

		l=list(set(l))
		l=sorted(l)
		
		ans=0
		low=0
		high=10**10

		while(low<=high):
			mid=(low+high)//2

			cm=check(l,mid)
			cl=check(l,mid-1)
			cr=check(l,mid+1)

			if(cm<=cl and cm<=cr):
				ans=mid
				break
			elif(cm<=cl and cm>=cr):
				low=mid+1
			else:
				high=mid-1


		b=[]
		for i in a:
			if(i!=-1):
				b.append(i)
			else:
				b.append(ans)
		val=0
		for i in range(1,n):
			val=max(val,abs(b[i]-b[i-1]))

		print(val,ans)
		

