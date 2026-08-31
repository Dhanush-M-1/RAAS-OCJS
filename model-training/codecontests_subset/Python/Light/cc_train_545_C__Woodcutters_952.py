n=int(input())
a=list()
tree=0
for i in range(0,n):
	l=list(map(int,input().split(" ")))
	a.append(l)
for i in range(1,n-1):
	if (a[i][0]-a[i][1]>a[i-1][0]) and (a[i][0]+a[i][1]>=a[i+1][0]):
		tree=tree+1
	elif (a[i][0]-a[i][1]<=a[i-1][0]) and (a[i][0]+a[i][1]<a[i+1][0]):
		a[i][0]=a[i][0]+a[i][1]
		tree=tree+1
	elif (a[i][0]-a[i][1]>a[i-1][0]) and (a[i][0]+a[i][1]<a[i+1][0]):
		tree=tree+1
if n>2:
	print(tree+2)
else:
	print(n)