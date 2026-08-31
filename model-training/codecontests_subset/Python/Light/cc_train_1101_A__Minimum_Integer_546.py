t=int(input())
while t>0:
	t-=1
	s=input()
	s=s.split()
	l=int(s[0])
	r=int(s[1])
	d=int(s[2])
	if l>d:
		print(d)
	else:
		x=(r//d)+1
		print(x*d)