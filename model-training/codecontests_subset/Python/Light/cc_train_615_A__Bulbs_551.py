buttons,bulbs = list(map(int,input().split()))

b=[]
for i in range(buttons):
	n = list(map(int,input().split()))
	n.remove(n[0])
	for i in n:
		b.append(i)

if len(set(b)) == bulbs:
	print('YES')
else:
	print('NO')