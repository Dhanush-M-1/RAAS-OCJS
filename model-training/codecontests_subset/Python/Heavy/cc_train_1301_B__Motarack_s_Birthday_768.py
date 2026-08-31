t=int(input())
for i in range(t):
	n=int(input())
	l=list(map(int,input().split()))
	mn = 10**9+1
	mx = -2
	ans = 0
	for i in range(n):
		if(l[i]==-1):
			if(i-1>=0 and l[i-1]!=-1):
				mx=max(mx,l[i-1])
				mn=min(mn,l[i-1])
			if(i+1<n and l[i+1]!=-1):
				mn=min(mn,l[i+1])
				mx=max(mx,l[i+1])
		else:
			if(i-1>=0 and l[i-1]!=-1):
				ans=max(ans,abs(l[i]-l[i-1]))
			if(i+1<n and l[i+1]!=-1):
				ans=max(ans,abs(l[i]-l[i+1]))
	# print("mx",mx)
	# print("mn",mn)
	v=0
	if(mn!=10**9+1):
		v = mx-mn
		if(v%2!=0):
			z=v//2+1
		else:
			z=v//2
		v = mx-z
		ans=max(ans,z)
	print(ans,v)
