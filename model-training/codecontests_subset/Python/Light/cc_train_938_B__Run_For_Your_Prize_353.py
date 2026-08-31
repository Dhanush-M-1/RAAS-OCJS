n=int(input())
a=list(map(int,input().split()))
a.sort()
max=0
for i in range(n):
	min1=min(a[i]-1,1000000-a[i])
	if(min1>max):
		max=min1
print(max)		