n=int(input())
a=[x for x in input().split()]
b=[x for x in input().split()]
c=[x for x in input().split()]
a.sort()
b.sort()
c.sort()
for i in range(0,n):
	if(i==n-1):
		print(a[i])
	elif(a[i]!=b[i]):
		print(a[i])
		break

for i in range(0,n-1):
	if(i==n-2):
		print(b[i])
	elif(b[i]!=c[i]):
		print(b[i])
		break

