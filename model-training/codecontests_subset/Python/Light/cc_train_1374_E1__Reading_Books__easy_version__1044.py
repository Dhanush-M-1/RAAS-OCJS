n,k=map(int,input().split())
a,b,c=[],[],[]
for i in range(n):
	t,x,y=map(int,input().split())
	if x==y==1:c.append(t)
	elif x==1:a.append(t)
	elif y==1:b.append(t)
a.sort();b.sort()
for i in range(min(len(a),len(b))):
	c.append(a[i]+b[i])
c.sort()
if len(c)<k:print(-1)
else:print(sum(c[:k]))