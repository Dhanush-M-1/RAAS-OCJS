n,k=map(int,input().split())
a=list(map(int,input().split()))
min1=float("inf")
for i in range(n):
	if k%a[i]==0:
		if k//a[i]<min1:
			min1=k//a[i]
print(min1)