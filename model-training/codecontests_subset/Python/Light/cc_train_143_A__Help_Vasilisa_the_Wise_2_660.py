
r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())


l1 = []
l2 = []

for i in range(1, 10):
	for j in range(1, 10):
		if i + j == r1:
			l1.append([i, j])

		if i + j == r2:
			l2.append([i, j])
lp = []
for i in l1:
	for j in l2:
		if i[0] + j[0] == c1 and i[1] + j[1] == c2:
			lp.append([i, j])

li = []
for i in lp:
	if i[0][0] + i[1][1] == d1 and i[0][1] + i[1][0] == d2:
		li.append(i) 

if len(li) == 0:
	print(-1)
	exit()
for i in li:
	cl = [i[0][0], i[1][0], i[1][1], i[0][1]]
	if len(cl) == len(set(cl)):
		print(i[0][0], i[0][1])
		print(i[1][0], i[1][1])
		exit()

print(-1)
