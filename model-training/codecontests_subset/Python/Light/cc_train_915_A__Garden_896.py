n,k=input().split(" ")
n=int(n)
k=int(k)
a=input().split(" ")
for i in range(n):
	a[i]=int(a[i])
#print(a)
a.sort()
a.reverse()
#print(a)
for i in range(n):
	if k%a[i]==0:
		x=k//a[i]
		break
print(x)	