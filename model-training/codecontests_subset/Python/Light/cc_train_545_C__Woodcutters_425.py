from sys import stdin, stdout
cin = stdin.readline
cout = stdout.write

n = int(cin())
a = []
for _ in range(n):
	a.append(list(map(int, cin().split())))
a.append([10**10, 10**10])
#print(a)
count = 1
x = a[0][0]

for i in range(1, n):
	if a[i][0] - a[i][1] > x:
		x = a[i][0]
		count += 1
	elif a[i][0] + a[i][1] < a[i+1][0]:
		x = a[i][0] + a[i][1]
		count += 1
	else:
		x = a[i][0]
cout(str(count) + '\n')