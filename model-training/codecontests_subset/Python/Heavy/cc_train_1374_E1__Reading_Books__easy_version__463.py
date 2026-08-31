def cta(t,p,r):
	global ana,iva,an
	ana[iva[t][p][1]]^=True
	an+=iva[t][p][0]*r

n,k=[int(x) for x in input().split()]
iva=[[] for _ in range(4)]
js=[() for _ in range(n)]
for i in range(n):
	v,o,u=[int(x) for x in input().split()]
	q=(o<<1)|u
	iva[q].append((v,i))
	js[i]=(v,q)
for e in iva :
	e.sort()

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

print(an)
