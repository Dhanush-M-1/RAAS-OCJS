t=int(input())
for j in range(t):
	n=int(input())
	a=[int(x) for x in input().split()]
	d_r=[]
	d_x=[]
	for i in range(1,len(a)):
		if a[i]!=-1 and a[i-1]!=-1:
			d_r.append(abs(a[i]-a[i-1]))
		elif a[i]==-1 and a[i-1]!=-1:
			d_x.append(a[i-1])
		elif a[i]!=-1 and a[i-1]==-1:
			d_x.append(a[i])
	if len(d_r)==0:
		Max=0
	else:
		Max=max(d_r)
	if len(d_x)==0:
		xMax,xMin=0,0
	else:
		xMax,xMin=max(d_x),min(d_x)
	k=(xMin+xMax)//2
	m=xMax-k if xMax-k>Max else Max
	print(m,k)

 		 		  			   	 	  					 	 	