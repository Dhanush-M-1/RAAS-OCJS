t=int(input())
for x in range(t):
	n=int(input())
	ar=list(map(int,input().split()))
	mx=ar[0]
	ind=0
	sp=[]
	sp.append([])
	sp[-1].append(mx)
	sp[-1].append(1)
	for i in range(1,n):
		if ar[i]==sp[-1][0]:
			sp[-1][1]+=1
		else:
			sp.append([])
			sp[-1].append(ar[i])
			sp[-1].append(1)
	g=sp[0][1]
	mxk=n//2
	mxk-=g
	fl=False
	if mxk<=0:
		fl=True
	lst=1
	s=0
	for i in range(1,len(sp)):
		if s<=g:
			s+=sp[i][1]
			mxk-=sp[i][1]
			lst=i
		if mxk<=0:
			fl=True
			break
	lst+=1
	if lst!=len(sp):
		b=0
		ne=0
		for i in range(lst,len(sp)):
			if b<=g:
				b+=sp[i][1]
				mxk-=sp[i][1]
				ne=i
			if mxk<0:
				fl=True
				break
		if mxk>0:
			ne+=1
			while mxk>0:
				if ne<len(sp)and mxk-sp[ne][1]>=0:
					mxk-=sp[ne][1]
					b+=sp[ne][1]
					ne+=1
				else:
					mxk=0
					break
	else:
		fl=True
	if mxk<0:
		fl=True
	if fl:
		print(0,0,0)
	else:
		print(g,s,b)