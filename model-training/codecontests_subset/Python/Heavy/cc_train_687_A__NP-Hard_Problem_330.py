n,m = map(int,input().split())
g = [set() for i in range(n)]
for i in range(m):
	a,b = map(int,input().split())
	g[a-1].add(b-1)
	g[b-1].add(a-1)
a = []
p = [-1]*n
for i in range(n):
	if p[i]!=-1:
		continue
	p[i] = 0
	a.append(i)
	while a:
		x = a.pop()
		for node in g[x]:
			if p[node]==p[x]:
				print(-1)
				exit()
			if p[node]==-1:
				p[node] = not p[x]
				a.append(node)
print(p.count(0))
for i in range(n):
	if p[i]==0:
		print(i+1,end = " ")
print()
print(p.count(1))
for i in range(n):
	if p[i]==1:
		print(i+1,end = " ")
print()