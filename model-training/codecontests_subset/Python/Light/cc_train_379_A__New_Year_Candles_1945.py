s=0
a,b=map(int,input().strip().split()[:2])
k=a
while a>=b:
	p=a//b
	s+=p
	a=p+(a%b)
print(k+s)
