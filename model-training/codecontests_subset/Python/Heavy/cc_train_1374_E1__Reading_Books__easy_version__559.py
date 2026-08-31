n,k = map(int,input().split())
a = []
b = []
c = []
at = 0
bt = 0
alo = 0
blo = 0
clo = 0
for i in range(n):
	t,al,bl = map(int,input().split())
	if al == 1 and bl == 1:
		at += 1
		bt += 1
		clo += 1
		c.append(t)
	elif al == 1:
		at += 1
		alo += 1
		a.append(t)
	elif bl == 1:
		bt += 1
		blo += 1
		b.append(t)
if at<k or bt<k:
	print("-1")
else:
	total = 0
	time = 0
	a.sort()
	b.sort()
	c.sort()
	j = 0
	r = 0
	while total<k:
		if j == alo or j == blo:
			time = time+c[r]
			r += 1
		elif r == clo:
			time = time+a[j]+b[j]
			j += 1
		else:
			if a[j]+b[j] < c[r]:
				time = time+a[j]+b[j]
				j += 1
			else:
				time = time+c[r]
				r += 1
		total += 1
	print(time)



