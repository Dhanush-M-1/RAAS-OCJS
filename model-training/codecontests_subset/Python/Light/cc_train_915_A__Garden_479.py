n,k=map(int,input().split())
min=101
count=0
x=0
b=input().split()
a=list(map(int,b))
for i in range(n):
	while x<k:
		x+=a[i]
		count+=1
	if x==k:
		if min>count:
			min=count
		count=0
		x=0
	else:
		count=0
		x=0
print(min)