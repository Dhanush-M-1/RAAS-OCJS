p = input()
n = int(input())
l = list()
for i in range(n):
	l.append(input())

yes = False
for i in range(n):
	for j in range(n):
		if l[i] == p or l[j] == p or (l[i][1] == p[0] and l[j][0] == p[1]) or (l[j][1] == p[0] and l[i][0] == p[1]):
			yes = True
			break

print("YES" if yes else "NO")