n,x,y=[int(i) for i in input().split()]
clone=0
z=False
if not x/n*100<y:
	print(0)
	z=True
while x/n*100<y:
	x+=1
	clone+=1
if not z: print(clone)
