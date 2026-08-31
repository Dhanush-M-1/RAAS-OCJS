a,b=map(int,input().strip().split())
c=d=0
while(a+d):
	a-=1
	c+=1
	
	if(c%b==0):
		d+=1
		
print(c)
