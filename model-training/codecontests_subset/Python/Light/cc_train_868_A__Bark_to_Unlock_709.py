
passw = input()
n = int(input())
l = []
for _ in range(n):
	l.append(input())

'''
for i in range(n):
	for j in range(i, n):
		ansGuess = (l[i] + l[j]) * 2
		if passw in ansGuess:
			print('YES')
			exit()

print('NO')
'''
#approach 2
if passw in l:
	print('YES')
	exit()

for i in range(n):
	if l[i][1] == passw[0]:
		break

else:
	print('NO')
	exit()


for i in range(n):
	if l[i][0] == passw[1]:
		break

else:
	print('NO')
	exit()

print('YES')