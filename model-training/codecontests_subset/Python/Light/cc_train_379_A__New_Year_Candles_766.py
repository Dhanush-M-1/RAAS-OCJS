a,b=map(int,input().split())
s=a
while a//b>0:
	s=s+a//b
	a=a%b+a//b
print(s)