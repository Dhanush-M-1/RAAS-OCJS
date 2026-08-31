a,b=map(int,input().split())
t=a
while a//b>0:
	t+=a//b
	a-=a//b*(b-1)
print(t)
	
