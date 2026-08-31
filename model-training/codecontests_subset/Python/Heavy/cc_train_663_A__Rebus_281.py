l = str(input()).split(' ')
pos=1
n=0
neg=0
dum=[]
for x in range(1, len(l)):
	if(l[x]=='='):
		n = int(l[x+1])
		break
	elif l[x]=='+':
		pos+=1
		dum.append('+')
	elif l[x]=='-':
		neg+=1
		dum.append('-')
if neg==0:
	if(n%pos!=0):
		print("Impossible")
		exit(0)
	print("Possible")
	res = ""
	for i in range(pos):
		res += str(n//pos) + ' '
		if(i!=pos-1):
			res+= "+ "
	res += "= " + str(n)
	print(res)
	exit(0)
tot = pos+neg
ps=-1
ys=-1
mds=0
a1, a2=[], []
for y in range(1, n+1):
	z = n + y*neg
	if ((z+pos-1)//(pos))<=n and (z//pos)>=1:
		ys=y
		ps=(z)//pos
		mds=z%pos
		break
if ys==-1:
	for x in range(1, n+1):
		if(x*pos-n<=0):
			continue
		z = x*pos-n
		if ((z+neg-1)//neg)<=n and (z//neg)>=1:
			ys=z//neg
			mds=z%neg
			ps=x
			break
	if(ys==-1):
		print("Impossible")
		exit(0)
	for i in range(mds):
		a2.append(ys+1)
	for i in range(neg-mds):
		a2.append(ys)
	for i in range(pos):
		a1.append(ps)
for i in range(mds):
	a1.append(ps+1)
for i in range(pos-mds):
	a1.append(ps)
for i in range(neg):
	a2.append(ys)
res=str(a1[0])+' '
u1, u2=1,0
for i in range(1, len(l)):
	if(l[i]=='+'):
		res += "+ " + str(a1[u1])+' '
		u1+=1
	elif(l[i]=='-'):
		res += "- " +str(a2[u2])+' '
		u2+=1
	elif l[i]=='=':
		break
res +="= "+str(n)
print("Possible")
print(res)



