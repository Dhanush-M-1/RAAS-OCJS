n=int(input())
for i in range(n):
	ch=input()
	l=ch.split()
	a=int(l[0])
	b=int(l[1])
	c=int( l[2])
	i=0
	while True:
		i+=1
		d=c*i
		if d not in range(a,b+1):
			print(d)
			break
		else:
			print((b//c)*c+c)
			break
				
					
