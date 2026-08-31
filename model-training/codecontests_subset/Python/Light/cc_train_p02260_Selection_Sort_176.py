def select(a,n):
	ct=0
	for i in range(n-1):
		minv=i
		for j in range(i+1,n):
			if a[j]<a[minv]:
				minv=j
		t=a[i]
		a[i]=a[minv]
		a[minv]=t
		if a[i]!=a[minv]:
			ct+=1
	return a,ct

n=int(input())
table=list(map(int,input().split()))
b,c=select(table,n)
print(*b)
print(c)
