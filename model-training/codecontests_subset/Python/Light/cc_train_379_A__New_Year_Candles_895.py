m,n=map(int,input().split())
b=1+m
a=0
while(m//n>=1):
	a+=m//n
	m=m//n+(m-(m//n)*n)
print(a+b-1)