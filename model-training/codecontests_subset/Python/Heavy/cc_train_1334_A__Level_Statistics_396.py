n_cases = int(input())
output = []
for i in range(0,n_cases):
	n_peeks = int(input())
	pairs = []
	for i in range(0,n_peeks):
		pairs.append(list(map(int,input().split())))
	poss = "YES"
	for i in range(1,len(pairs)):
		if (pairs[i][0] < pairs[i-1][0]) or ((pairs[i][1] - pairs[i-1][1]) > (pairs[i][0] - pairs[i-1][0])) or (pairs[i][1] < pairs[i-1][1]) or (pairs[i][0] < pairs[i][1]):
			poss = "NO"
			break
	if len(pairs) > 0 and pairs[0][0] < pairs[0][1]:
		poss = "NO"
	output.append(poss)
for i in range(0,len(output)):
	print(output[i])