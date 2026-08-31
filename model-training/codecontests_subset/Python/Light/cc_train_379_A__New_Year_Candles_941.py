a,b=list(map(int,input().split()))
c=0
d=0
while a>=b:
	c=c+int(a/b)*b
	a=a-int(a/b)*b+int(a/b)
c+=a
print(c)