a,b=map(int,input().split())
l=[]
for i in range(a):
	k=list(map(int,input().split()))
	for i in k[1::]:
		l.append(i)
print(['NO','YES'][len(set(l))==b])	
