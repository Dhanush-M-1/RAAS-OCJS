l=list(map(int,input().split(" ")))
button=l[0]
bulb=l[1]
a=[0]*bulb
for i in range(0,button):
	b=list(map(int,input().split(" ")))
	c=b[1:b[0]+1]
	for j in c:
		a[j-1]=a[j-1]+1
for i in a:
	k=1
	if i==0:
		k=0
		print("NO")
		break
if k!=0:
	print("YES")
