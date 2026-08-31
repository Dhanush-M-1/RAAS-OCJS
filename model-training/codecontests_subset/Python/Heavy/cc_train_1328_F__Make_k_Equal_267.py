ll = lambda:list(map(int, input().split()))
testcases = 1
# [testcases] = ll()
def step(s,e):
	if s==e:
		return 0
	elif s<e:
		return -1
	count=0
	while(s>e):
		count+=1
		s = s//2
		if(s==e):
			return count
	return -1


for _ in range(testcases):
	[n,k] = ll()
	a =ll()
	a.sort()
	minres = 999999999
	t = a[-1]
	ix = -1
	for i in range(1,t+1):
		steps = []
		for j in a:
			x = step(j,i)
			if x!=-1:
				steps.append(x)
		if len(steps) < k:
			continue
		steps.sort()
		# print(steps,i)
		if minres > sum(steps[:k]):
			minres = sum(steps[:k])

			ix = i
	print(minres)
