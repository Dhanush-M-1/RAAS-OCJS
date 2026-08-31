t=int(input())
for i in range(t):
	n=int(input())
	x=[]
	for j in range(n):
		a=list(map(int,input().split()))
		x.append(a)
	flag='YES'
	if(n==1):
		if(x[0][1]>x[0][0]):
			flag='NO'
		print(flag)
	else:
		for j in range(len(x)-1):
			if((x[j+1][0]<x[j][0] or x[j+1][0]<x[j+1][1]) or (x[j+1][1]<x[j][1] or x[j][0]<x[j][1])):
				flag='NO'
				break
			if(x[j+1][0]==x[j][0] and x[j+1][1]!=x[j][1]):
				flag='NO'
				break
			r=x[j+1][0]-x[j][0]
			if((x[j+1][1]-x[j][1])>r):
				flag='NO'
				break
		print(flag)