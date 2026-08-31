s = input()
n = int(input())
words = [input() for i in range(n)]
k = 0
for i in words:
	for j in words:
		if s in i + j:
			k += 1
			break
	if k >= 1:
		print('YES')
		break
if k == 0:
	print('NO')
