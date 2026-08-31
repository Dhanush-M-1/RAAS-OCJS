def cta(t,p,r):
	global ana,iva,an
	ana[iva[t][p][1]]^=True
	an+=iva[t][p][0]*r

n,m,k=[int(x) for x in input().split()]

iva=[[] for _ in range(4)]
alv=[() for _ in range(n)]
for i in range(n):
	v,o,u=[int(x) for x in input().split()]
	q=(o<<1)|u
	iva[q].append((v,i))
	alv[i]=(v,i)
for e in iva :
	e.sort()
alv.sort()

ct,a,r,ps,an = 0,0,0,min(len(iva[1]),len(iva[2])),0
ana=[False]*n
for _ in range(k):
	if(a<ps and r<len(iva[3])):
		if(iva[1][a][0]+iva[2][a][0]<iva[3][r][0]) :
			cta(1,a,1)
			cta(2,a,1)
			ct+=2
			a+=1
		else:
			cta(3,r,1)
			ct+=1
			r+=1
	elif (a<ps):
		cta(1,a,1)
		cta(2,a,1)
		ct+=2
		a+=1		
	elif(r<len(iva[3])):
		cta(3,r,1)
		ct+=1
		r+=1		
	else:
		print(-1)
		exit(0)

while (ct>m and a>0 and r<len(iva[3])):
	a-=1
	cta(1,a,-1)
	cta(2,a,-1)
	cta(3,r,1)
	ct-=1
	r+=1

ap=0
while(ct<m and  ap<n ):	
	if (not ana[alv[ap][1]]):		
		if(r>0 and a<ps and iva[1][a][0]+iva[2][a][0]-iva[3][r-1][0]<alv[ap][0] ):
			if ana[iva[1][a][1]] or ana[iva[2][a][1]] :
				a+=1
				continue
			r-=1
			cta(1,a,1)
			cta(2,a,1)
			cta(3,r,-1)
			a+=1
			ct+=1
		else:
			ct+=1
			an+= alv[ap][0];
			ana[alv[ap][1]]=True;
			ap+=1
	else:ap+=1

if (ct!=m) :	print(-1)
else:
	print(an)
	for i in range(n):
		if(ana[i]):
			print(i+1,end=" ")
