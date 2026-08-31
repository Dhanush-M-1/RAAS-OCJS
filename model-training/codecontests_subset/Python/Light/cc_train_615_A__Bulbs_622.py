n,m=map(int,input().split())
yy=[]
for i in range(n):
	x=list(map(int,input().split()))
	x=x[1:]
	yy.append(x)

main=[]
for i in yy:
	for j in i:
		main.append(j)

main=set(main)

gg={0}
for i in range(1,m+1):
	gg.add(i)

gg.remove(0)

if(gg==main):
	print("YES")
else:
	print("NO")

		
	