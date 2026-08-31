import sys
input = sys.stdin.readline
for nt in range(int(input())):
	n = int(input())
	a = list(map(int,input().split()))
	c = a.count(-1)
	if c==n:
		print (0,1)
		continue
	elif c==n-1:
		print (0,sum(a)+n-1)
		continue
	
	minn = max(a)
	maxx = 0
	for i in range(1,n):
		if a[i]==-1 and a[i-1]!=-1:
			minn = min(minn,a[i-1])
			maxx = max(maxx,a[i-1])
	for i in range(n-1):
		if a[i]==-1 and a[i+1]!=-1:
			minn = min(minn,a[i+1])
			maxx = max(maxx,a[i+1])

	ans = (minn+maxx)//2
	for i in range(n):
		if a[i]==-1:
			a[i] = ans
	maxx = 0
	for i in range(1,n):
		maxx = max(maxx,abs(a[i]-a[i-1]))
	print (maxx,ans)