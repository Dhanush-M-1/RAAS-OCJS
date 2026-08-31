
passw = input()
n = int(input())
l = []
for _ in range(n):
	l.append(input())


for i in range(n):
	for j in range(i, n):
		ansGuess = (l[i] + l[j]) * 2
		if passw in ansGuess:
			print('YES')
			exit()

print('NO')