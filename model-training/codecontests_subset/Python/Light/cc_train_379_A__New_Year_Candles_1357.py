x,y = map(int,input().split(" "))
a = 0;c = 0
while x>0.1:
	a += x 
	x = x/y
	pass
print(int(a))