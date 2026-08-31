from sys import stdin

n,k=map(int,input().split())
x=[]
y=[]
z=[]
k1=0
k2=0
for i in range(n):
	t,a,b=map(int,stdin.readline().split())
	if(a==1 and b==1):
		x.append(t)
		k1+=1
		k2+=1
	else:
		if(a==1):
			k1+=1
			y.append(t)
		elif(b==1):
			k2+=1
			z.append(t)	
if(k1<k or k2<k):
	print(-1)
else:
	x.sort()
	y.sort()
	z.sort()
	ans=0
	k1=0
	k2=0
	p1=0
	p2=0
	p3=0
	lx=len(x)
	ly=len(y)
	lz=len(z)
	for i in range(k):
		if(p1>=lx):
			ans+=y[p2]+z[p3]
			p2+=1
			p3+=1
		elif(p2>=ly or p3>=lz):
			ans+=x[p1]
			p1+=1
		else:
			if(x[p1]<=y[p2]+z[p3]):
				ans+=x[p1]
				p1+=1
			else:
				ans+=y[p2]+z[p3]
				p2+=1
				p3+=1
	print(ans)