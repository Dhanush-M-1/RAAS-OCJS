n,m = map(int,input().split())
l1 = []
l2 = []
for _ in range(n):
	a,b = map(int,input().split())
	l1.append((a,b))
for _ in range(m):
	c,d = map(int,input().split())
	l2.append((c,d))
for a,b in l1:
	mi = 1e9
	i = 0
	for j,(c,d) in enumerate(l2):
		dist = abs(a-c)+abs(b-d)
		if dist < mi:
			mi = dist
			i = j
	print(i+1)