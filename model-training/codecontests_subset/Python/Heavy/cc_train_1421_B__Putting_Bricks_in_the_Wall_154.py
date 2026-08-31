def flip(n):
	if n=='0':
		return '1'
	else:
		return '0'
def hi(a):
	n = len(a)
	c = 0
	f = []
	if a[0][1]==a[1][0] and a[n-1][n-2]==a[n-2][n-1] and a[0][1]!=a[n-1][n-2]:
		return c,[]

	if a[0][1]==a[1][0]:
		p = a[0][1]
		if a[n-1][n-2]==p:
			a[n-1][n-2] = flip(p) 
			c+=1
			f.append([str(n),str(n-1)])
		if a[n-2][n-1]==p:
			a[n-2][n-1] = flip(p) 
			c+=1
			f.append([str(n-1),str(n)])
		return c,f
	else:
		if a[n-1][n-2]==a[n-2][n-1]:
			p = a[n-1][n-2]
			if a[0][1]==p:
				a[0][1] = flip(p)
				c+=1
				f.append(['1','2'])
			else:
				a[1][0] = flip(p)
				c+=1
				f.append(['2','1'])
			return c,f
		else:
			p = a[n-1][n-2]
			a[n-2][n-1] = p
			c+=1
			f.append([str(n-1),str(n)])
			if a[0][1]==p:
				c+=1
				a[0][1] = flip(p)
				f.append(['1','2'])
			else:
				c+=1
				a[1][0] = flip(p)
				f.append(['2','1'])
			return c,f

		
t = int(input())
b = [[] for i in range(2*t)]
for i in range(t):
	p = int(input())
	a = []
	for j in range(p):
		a.append(list(input()))
	b[2*i],b[2*i+1] = hi(a)
for i in range(len(b)):
	if i%2==0:
		print(b[i])
	else:
		if len(b)==0:
			pass
		else:
			for j in range(len(b[i])):
				p = " ".join(b[i][j])
				print(p)