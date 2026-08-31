a,b=map(int,input().split())
x=a
while True:
	d=x//b
	z=x%b
	a+=d
	x=d+z
	if d==0:
		break
print(a)