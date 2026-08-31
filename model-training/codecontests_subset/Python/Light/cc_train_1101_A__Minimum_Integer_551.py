


def rI():
	return [int(i) for i in input().split()]


q = rI()[0]

for i in range(q):
	l,r,d = rI()
	if(d < l or d > r):
		print(d)
		continue
	oo = r // d
	print((oo+1)*d)