n=int(input())
a=[[int(x) for x in input().split() ]for i in range(n)]
f=[[0,0,0] for i in range(n)]
f[0][0]=f[0][1]=1
if n==1:
	print(n)
else:
	for i in range(1,n):
		if a[i-1][1]+a[i][1]<a[i][0]-a[i-1][0]:
			f[i][0]=f[i-1][1]+1
		if a[i][1]<a[i][0]-a[i-1][0]:
			f[i][0]=max(f[i][0],f[i-1][0]+1,f[i-1][2]+1)
		if a[i-1][1]<a[i][0]-a[i-1][0]:
			f[i][2]=f[i-1][1]
		f[i][2]=max(f[i][2],f[i-1][2],f[i-1][0])

		if a[i-1][1]<a[i][0]-a[i-1][0]:
			f[i][1]=f[i-1][1]+1
		f[i][1]=max(f[i][1],f[i-1][0]+1,f[i-1][2]+1)
	print(max(f[n-1][0],f[n-1][1],f[n-1][2]))
