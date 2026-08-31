for _ in range(int(input())):
	l,r,d=map(int,input().strip().split()[:3])
	if d not in range(l,r+1):
		print(d)
	else:
		if l%d==0:
			k=l-d
			if k<=0:
				if r%d==0:
					k=r+d
				else:
					k=r+(d-(r%d))
		else:
			k=l-(l%d)
			if k<=0:
				if r%d==0:
					k=r+d
				else:
					k=r+(d-(r%d))
		print(k)