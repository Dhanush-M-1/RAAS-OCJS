first = input().split()
n = int(input())
names = []
for i in range(n):
	names.append(tuple(input().split()))
print(' '.join(first))
for i in range(len(names)):
	if first[0] == names[i][0]:
		first[0] = names[i][1]
	else:
		first[1] = names[i][1]
	print(' '.join(first))