t=int(input())
i=int(0)
for i in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	b=[]
	j=int(0)
	for j in range(n):
		if j==0:
			if (a[j+1]==-1 and a[j]!=-1):
				b.append(a[j])
		elif j==n-1:
			if (a[j-1]==-1 and a[j]!=-1):
				b.append(a[j])
		else:
			if ((a[j-1]==-1 or a[j+1]==-1) and a[j]!=-1):
				b.append(a[j])
	b.sort()
	m=int(0)
	j=int(0)
	if len(b):
		x=int((b[0]+b[-1])//2)
	else:
		x=int(0)
	for j in range(n-1):
		if a[j]==-1:
			a[j]=x
		if a[j+1]==-1:
			a[j+1]=x
		if abs(a[j+1]-a[j])>m:
			m=abs(a[j+1]-a[j])
	print(m,x)