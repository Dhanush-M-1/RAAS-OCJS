n,k=[int(x) for x in input().split(' ')]
time=[]
a=[]
b=[]
for i in range(n):
	p,q,r=[int(x) for x in input().split(' ')]
	time.append(p)
	a.append(q)
	b.append(r)
oa=[]
ob=[]
bo=[]
no=[]
for i in range(n):
	if(a[i] and b[i]):
		bo.append(i)
	elif(a[i] and b[i]==0):
		oa.append(i)
	elif(a[i]==0 and b[i]):
		ob.append(i)
	else:
		no.append(i)
if((len(bo)+len(oa)<k) or (len(bo)+len(ob)<k)):
	print(-1)
else:
	def time_req(i):
		return(time[i])
	oa.sort(key=time_req)
	ob.sort(key=time_req)
	bo.sort(key=time_req)
	oa.reverse()
	ob.reverse()
	bo.reverse()
	books=set()
	for i in range(k):
		if(len(oa)==0 or len(ob)==0):
			books.add(bo.pop())
			continue
		elif(len(bo)==0):
			books.add(oa.pop())
			books.add(ob.pop())
			continue
		if(time[bo[-1]]<(time[oa[-1]]+time[ob[-1]]) or len(oa)==0 or len(ob)==0):
			books.add(bo.pop())
		else:
			books.add(oa.pop())
			books.add(ob.pop())
	print(sum(list(map(time_req,list(books)))))