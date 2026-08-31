names = input().split(' ')
days = int(input())
print(names[0] + ' ' + names[1])
for i in range(days):
	names2 = input().split(' ')
	if(names2[0]==names[0]):
		names[0] = names2[1]
	else:
		names[1] = names2[1]
	print(names[0] + ' ' + names[1])
