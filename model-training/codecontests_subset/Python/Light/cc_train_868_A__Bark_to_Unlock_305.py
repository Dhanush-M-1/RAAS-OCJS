t = input()
n = int(input())
l = []
flag = 0
for i in range(n):
	l.append(input())
for i in range(n):
	for j in range(i,n):
		if t in l[i]+l[j] or t in l[j] + l[i]:
			print("YES")
			exit()
print("NO")
