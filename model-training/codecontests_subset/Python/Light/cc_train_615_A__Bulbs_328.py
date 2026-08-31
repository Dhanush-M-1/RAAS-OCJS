
l = list(map(int, input().split()))
l1 = []
for _ in range(l[0]):
	l1.append(list(map(int, input().split())))
l3 = []
for i in range(l[0]):
	for j in range(1, len(l1[i])):
		l3.append(l1[i][j])

se = set(l3)
for i in range(1, l[1] + 1):
	if i not in se:
		print('NO')
		exit()

print('YES')

