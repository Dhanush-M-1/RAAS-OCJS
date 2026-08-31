t = int(input())

for _ in range(t):
	n = int(input())
	p = list(map(int, input().split()))

	if n<5:
		print(0,0,0)
		continue
	n_medals= n//2

	pts = []
	idx=0
	while idx<n:
		cnt = 0
		pt = p[idx]
		while idx<n and pt==p[idx]:
			idx+=1
			cnt+=1
		pts.append(cnt)

	g = pts[0]
	n_medals-=g
	s = 0
	idx = 1
	while s<=g and idx<len(pts):
		s+=pts[idx]
		idx+=1
	n_medals-=s
	b = 0
	while idx<len(pts):
		if pts[idx] <= n_medals:
			n_medals -= pts[idx]
			b += pts[idx]
			idx += 1
		else:
			break

	if b<=g:
		print(0,0,0)
	else:
		print(g,s,b)
