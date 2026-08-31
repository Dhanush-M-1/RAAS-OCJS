for _ in range(int(input())):
	n = int(input())
	a = input().split()
	d={}
	for i in a:
		if int(i) not in d.keys():
			d[int(i)]=1
		else:
			d[int(i)]+=1
	l = list(d.keys())
	l.sort(reverse=True)
	s=set()
	c=0
	i=0 
	while i<len(l):
		c+=d[l[i]]
		if c>n//2:
			c-=d[l[i]]
			break
		else:
			s.add(l[i])
			i+=1
	l = list(s)
	l.sort(reverse=True)
	g=s=b=0
	if len(l):
		g = d[l[0]]
	i=1
	while i<len(l):
		if s<=g:
			s+=d[l[i]]
			i+=1
		else:
			b+=d[l[i]]
			i+=1
	if g<s and g<b:
		print(g,s,b)
	else:
		print("0 0 0")