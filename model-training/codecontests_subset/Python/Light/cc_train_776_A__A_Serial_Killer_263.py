l=list(map(str,input().split()))
m=[]

m.append(l)
n=int(input())
for i in range(n):
	s=list(map(str,input().split()))
	m.append(s)
z=[]
for i in range(n+1):
	for j in range(2):
		if m[i][j] not in z:
			z.append(m[i][j])
			if len(z)==2:
				print(" ".join(z))
		elif m[i][j] in z:
			z.remove(m[i][j])