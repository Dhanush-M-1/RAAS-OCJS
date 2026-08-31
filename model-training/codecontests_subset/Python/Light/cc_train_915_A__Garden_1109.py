n,k=[int(x)for x in input().split()]
a=[int(x)for x in input().split()]
maxx=0
for i in range(n):
	if (k%a[i]==0)and (a[i]>maxx):
		maxx=a[i]
print (int(k/maxx))
