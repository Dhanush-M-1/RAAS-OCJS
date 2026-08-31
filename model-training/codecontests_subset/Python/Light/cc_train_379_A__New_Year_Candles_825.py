a,b=map(int,input().split())

x=a
while a>=b:
	x=x+a//b
	a=a//b +a%b
print(x)
		