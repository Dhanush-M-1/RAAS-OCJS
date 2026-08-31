a,b=map(int,input().split())
i=1
while a>0:
	a-=1
	if i%b==0:
		a+=1
	i+=1
print(i-1)