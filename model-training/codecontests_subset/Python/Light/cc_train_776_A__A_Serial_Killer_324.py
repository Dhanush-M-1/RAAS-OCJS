n1, n2 = input().split()
n = int(input())
listkilled = []
listadded = []
answer = [n1+' '+n2]
for i in range(n):
	tmp = input().split()
	listkilled.append(tmp[0])
	listadded.append(tmp[1])
for i in range(n):
	k = answer[i].split()
	if k[0] == listkilled[i]:
		answer.append(listadded[i] + ' ' + k[1])
	else:
		answer.append(listadded[i] + ' ' + k[0])
for i in range(n+1):
	print(answer[i])