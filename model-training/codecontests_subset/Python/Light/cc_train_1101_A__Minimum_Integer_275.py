q = int(input())
for t in range(q):
	l,r,d = map(int,input().split())
	a = l//d
	b = r//d
	if a*d==l:
		a-=1
		if a==1:
			print(d)
		elif a>1:
			print(d)
		else:
			if b*d==r:
				print(r+d)
			else:
				x = r-(r%d)
				x+=d
				print(x)
	elif l>=d:
		x = l - (l%d)
		if x//d >= 1:
			print(d)
		else:
			if b*d==r:
				print(r+d)
			else:
				x = r-(r%d)
				x+=d
				print(x)
	else:
		if b*d==r:
			print(r+d)
		else:
			x = r-(r%d)
			x+=d
			print(x)

