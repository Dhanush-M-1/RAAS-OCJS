n=int(input())
for i in range(n):
	a=list(map(int,input().split()))
	count=0
	c=[]
	c.append(a[0])
	c.append(a[1])
	c.append(a[2])
	a[0]=[a[0],0]
	a[1]=[a[1],1]
	a[2]=[a[2],2]
	a.sort(key=lambda x:x[0],reverse=True)
	if(c[1]>=1 and c[2]>=2):
		d=int(c[2]/2)
		if(d<=c[1]):
			count=count+d+d*2
			c[1]=c[1]-d
			c[2]=c[2]-d*2
		else:
			d=c[1]
			count=count+d+d*2
			c[1]=0
			c[2]=c[2]-d*2
	if(c[0]>=1 and c[1]>=2):
		d=int(c[1]/2)
		if(d<=c[0]):
			count=count+d+d*2
			c[0]=c[0]-d
			c[1]=c[1]-d*2
		else:
			d=c[0]
			count=count+d+d*2
			c[0]=0
			c[1]=c[1]-d*2
	print(count)