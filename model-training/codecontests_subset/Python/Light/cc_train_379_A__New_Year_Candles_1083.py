a,b=map(int,input().split(" "))
x = 0
while a>0.1:
	x+=a
	a = a/b	
	pass
print (int(x))
