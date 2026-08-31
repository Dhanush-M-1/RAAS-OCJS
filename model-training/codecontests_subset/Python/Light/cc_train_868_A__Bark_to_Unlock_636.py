Pass = input()


n = int(input())

words =[]
x = []
for i in range(n):
	words.append(input())

for i in range(n):
	for j in range(n):
		if (words[i][1]+words[j][0] == Pass):
			x.append('YES')
if Pass in words:
	x.append('YES')
if x.count('YES')==0:
	print('NO')
else :
	print('YES')