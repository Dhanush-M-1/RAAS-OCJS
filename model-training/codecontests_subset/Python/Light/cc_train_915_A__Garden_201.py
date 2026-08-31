n,w=map(int,input().split())
l=list(map(int,input().split()))
p=[]
for i in range(n):
	if w%l[i]==0:
		s=int(w/l[i])
		p.append(s)
print(min(p))
