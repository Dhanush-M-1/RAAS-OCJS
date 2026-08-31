t = int(input())

for i in range(t):
	n = int(input())

	l = []
	for j in range(n):
		p, c = map(int, input().split())
		l.append((p, c))

	s = l[0][0]
	e = l[0][1]

	verdict = True

	if s<e:
		verdict = False
	
	if verdict:
		for i in l[1:]:
			if i[0]<i[1]:
				verdict = False
				break

			if i[0]<s:
				verdict = False
				break

			if i[1]<e:
				verdict = False
				break

			if (i[1]-e)>(i[0]-s):
				verdict = False
				break

			s = i[0]
			e = i[1]
	

	if verdict:
		print("YES")
	else:
		print("NO")