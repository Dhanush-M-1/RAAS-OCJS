a,b=input().split()
a=int(a)
b=int(b)
c=a
while(a>=b):
	c+=int(a//b)
	a=int(a//b)+a%b
print(c)
