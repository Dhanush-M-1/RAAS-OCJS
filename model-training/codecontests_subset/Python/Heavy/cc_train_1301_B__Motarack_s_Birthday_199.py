# Problem:	B
# Date:		February 13 2020
# Author:	OBJECT.705X
def cmax(a,b):
	if(a>b): return a
	else: return b

def cmin(a,b):
	if(a>b): return b
	else: return a

t=int(input())
for tt in range(t):
	n=int(input())
	L,R=int(1000000000),int(0)
	ans,cnt=0,0;
	a=[int(x) for x in input().split()]
	for i in range(n):
		if(i>0 and a[i]!=-1 and a[i-1]!=-1):
			ans=cmax(ans,abs(a[i]-a[i-1]))
		if(a[i]!=-1):
			continue;
		cnt=cnt+1
		if(i>0 and a[i-1]!=-1):
			L=cmin(L,a[i-1])
			R=cmax(R,a[i-1])
		if(i!=n-1 and a[i+1]!=-1):
			L=cmin(L,a[i+1])
			R=cmax(R,a[i+1])
	if(cnt==n): ans=L=R=0
	ans=cmax(ans,(R-L+1)//2)
	print(ans,(L+R)//2)




