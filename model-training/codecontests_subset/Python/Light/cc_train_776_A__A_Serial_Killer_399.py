first = input().split(' ')
day = int(input())
tmp = []
tmp.append(first[0] + ' ' + first[1])
while day:
	second = input().split(' ')
	if (first[0] == second[0]):
		tmp.append(first[1] + ' ' + second[1])
	else:
		tmp.append(first[0] + ' ' + second[1])
	first = tmp[-1].split(' ')
	day -= 1
for i in tmp:
	print(i)