a,b=list(map(int,input().split()))

s,n,g=0,a,a
while g!=0:
	s+=int(n/b)
	g=int(n/b)
	n=g+(n%b)
print(a+s)