t = int(input())
for i in range(t):
	n = int(input())
	dop = list(map(int, input().split()))
	mas = []
	mas.append([dop[0], 1])
	for j in range(1, n):
		if mas[-1][0] == dop[j]:
			mas[-1][1] += 1
		else:
			mas.append([dop[j], 1])
	g = mas[0][1]
	m = len(mas)
	k = n // 2
	kol = g
	s = 0
	b = 0
	for j in range(1, m):
		kol += mas[j][1]
		if kol > k:
			break
		if s <= g:
			s += mas[j][1]
		else:
			b += mas[j][1]
	#print (g, s, b)
	if g != 0 and s != 0 and b != 0 and g < s and g < b and (g + b + s) <= k:
		print (g, s, b)
	else:
		print (0, 0, 0)
