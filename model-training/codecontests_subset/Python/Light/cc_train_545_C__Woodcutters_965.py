n=int(input())
a=[[0]*2]*n
for i in range(n):
	a[i]=[int(x) for x in input().split()]
N=2
for i in range(1,n-1):
	if a[i][0]-a[i][1]>a[i-1][0]:
		N+=1
	else:
		if a[i][0]+a[i][1]<a[i+1][0]:
			N+=1
			a[i][0]=a[i][0]+a[i][1]
print(n if n<2 else N)