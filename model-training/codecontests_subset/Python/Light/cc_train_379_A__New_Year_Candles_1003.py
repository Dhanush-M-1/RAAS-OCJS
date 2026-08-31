a,b=map(int,input().split())
tot=a
while a>=b:
	tot=tot+int(a/b)
	x=a%b
	a=int(a/b)
	a=a+x
print(int(tot))
