n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
d=e=0
for i in range(0,n-1):
	if(a[i]!=b[i]):
		print(a[i])
		d=1
		break
if(d==0):
		print(a[n-1])
for i in range(0,n-2):
	if(b[i]!=c[i]):
		print(b[i])
		e=1
		break
        
if(e==0):
		print(b[n-2])




  
	