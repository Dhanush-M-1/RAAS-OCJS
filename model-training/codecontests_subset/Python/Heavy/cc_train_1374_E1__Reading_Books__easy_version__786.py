

n,k=map(int,input().split())
a,b,tog=[],[],[]
for i in range(n):
	t,x,y=map(int,input().split())
	if x==1 and y==1:
		tog.append(t)
	elif x==1 and y==0:
		a.append(t)
	elif x==0 and y==1:
		b.append(t)
ltog=len(tog)
la=len(a)
lb=len(b)
if ltog+la<k or ltog+lb<k:
	print(-1)
else:
	a.sort(reverse=True)
	b.sort(reverse=True)
	tog.sort(reverse=True)
	ca,cb=0,0
	res=0
	while ca<k or cb<k:
		if tog:
			ptog=tog[-1]
		else:
			ptog=0
		if a:
			pa=a[-1]
		else:
			pa=0
		if b:
			pb=b[-1]
		else:
			pb=0
		if ca<k and cb<k:
			if pa and pb and ptog:
				if pa+pb<ptog:
					res+=pa+pb
					a.pop()
					b.pop()
				else:	
					res+=ptog
					tog.pop()
				ca+=1
				cb+=1
			elif ptog:
				res+=ptog
				tog.pop()
				ca+=1
				cb+=1
			elif pa and pb:
				res+=pa+pb
				a.pop()
				b.pop()
				ca+=1
				cb+=1
			else:
				res=-1
				break
		else:
			if ca<k:
				if pa and ptog:
					if pa<ptog:
						res+=pa
						a.pop()
						ca+=1
					else:	
						res+=ptog
						tog.pop()
						ca+=1
						cb+=1
				elif ptog:
					res+=ptog
					tog.pop()
					ca+=1
					cb+=1
				elif pa:
					res+=pa
					a.pop()
					ca+=1
				else:
					res=-1
					break
			elif cb<k:
				if pb and ptog:
					if pb<ptog:
						res+=pb
						b.pop()
						cb+=1
					else:	
						res+=ptog
						tog.pop()
						ca+=1
						cb+=1
				elif ptog:
					res+=ptog
					tog.pop()
					ca+=1
					cb+=1
				elif pb:
					res+=pb
					b.pop()
					cb+=1
				else:
					res=-1
					break
	print(res)
