
n,k=map(int,input().split())

share=[]
alice=[]
bob=[]

for i in range(n):
	t,a,b=map(int,input().split())
	if a and b:
		share.append(t)
	elif a:
		alice.append(t)
	elif b:
		bob.append(t)
share.sort()
cs=[0]
for i in share:cs.append(cs[-1]+i)

alice.sort()
ca=[0]
for i in alice:ca.append(ca[-1]+i)

bob.sort()
cb=[0]
for i in bob:cb.append(cb[-1]+i)

an=float("INF")

for i in range(min(len(share),k)+1):
	if len(alice)>=k-i and len(bob)>=k-i:
		an=min(an,cs[i]+ca[k-i]+cb[k-i])
if an==float("INF"):print(-1)
else:print(an)