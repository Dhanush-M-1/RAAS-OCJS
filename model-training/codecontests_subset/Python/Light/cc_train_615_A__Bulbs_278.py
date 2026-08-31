n,m = map(int,input().split())
d = []
e=set()




for i in range(n):
	s=[int(i) for i in input().split()]
	l = s[0]
	d.append(s[1:])
if s[0]==0:
	print("NO")
else:
	for i in d:
		for j in range(len(i)):
			e.add(i[j])
	e = list(e)

	if len(e)==max(e) and max(e)==m:
		print("YES")
	else:
		print("NO")