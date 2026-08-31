a,b = map(int,input().split())
m,n,o,ans=[],[],[],0
for _ in range(a):
	q,w,e= map(int,input().split())
	if w==e==1:m.append(q)
	elif w!=e:
		if e==0:n.append(q)
		else:o.append(q)
m.sort();n.sort();o.sort()
v,t,u=[],min(len(n),len(o)),len(m)
for i in range(t):
	v.append(n[i]+o[i])
if b>u+t:
	print(-1)
else:
	i,j=0,0
	while b>0:
		if  i<u and j<t:
			if m[i]<=v[j]:
				ans+=m[i]
				i+=1
			else:
				ans+=v[j]
				j+=1
		else:
			if i<=(u-1):
				ans+=m[i]
				i+=1
			elif j<=(t-1):
				ans+=v[j]
				j+=1
		b-=1
	print(ans)