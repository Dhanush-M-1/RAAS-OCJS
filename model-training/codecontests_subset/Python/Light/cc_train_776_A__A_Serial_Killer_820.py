x,y=input().split();a=[];p=[x,y]
a.append(x+' '+y)
for i in range(int(input())):
	m,n=input().split()
	if m in p:
		p[p.index(m)]=n
	else:
		p[p.index(n)]=m
	a.append(p[0]+' '+p[1])
for i in a:
	print(i)