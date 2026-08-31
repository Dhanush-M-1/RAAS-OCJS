n=int(input())
a=[[None]*2 for i in range(n)]
r=2
for i in range(n):
	a[i]=list(map(int,input().split()))
for i in range(1,n-1):
	if (a[i][1]-a[i][0]+a[i-1][0] <0) :
		r+=1
	elif ((sum(a[i]) - a[i + 1][0]) < 0):
		r+=1
		a[i][0]+=a[i][1]
if (n>=2):print(r)
else: print(1)
