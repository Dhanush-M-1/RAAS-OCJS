for _ in range((int(input()))):
	n=int(input())
	a=list(map(int,input().split()))
	ok=False
	for i in range(n-1):
		#print(a[i]+a[i+1]-a[n-1-i])
		if a[i]+a[i+1]<=a[n-1-i]:
			ok=True
			print(i+1,i+2,n-i)
			break
	if not ok:
		print(-1)