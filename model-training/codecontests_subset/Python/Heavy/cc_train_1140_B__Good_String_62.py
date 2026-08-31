def found():
	for i in range(n-1):
		if thing[i]=='<' and thing[i+1]=='>':
			problem = True
			problem_i = i
			break
		else:
			problem = False
			problem_i = i
	return problem,problem_i

def exe(x,y):
	if x == True and y == 0:
		if thing[n-1] == '<':
			return 0
		else:
			return 1
	elif x == True and y == n-2:
		if thing[0] == '>':
			return 0
		else:
			return 1
	elif x == True:
		if thing[0] == '>' and thing[n-1] == '<':
			return 0
		else:
			return min(calc(y,'<'),calc(y,'>'))
	else:
		return 0

def calc(y,z):
	count = 0
	if z == '<':
		for i in range(y+1):
			if thing[i] == '<':
				count += 1
			else:
				break
	elif z == '>':
		for i in range(n-1,y-1,-1):
			if thing[i] == '>':
				count += 1
			else:
				break
	return count
	
t = int(input())
for case in range(t):
	n = int(input())
	thing = input()
	if n == 1:
		ans = 0
	else:
		a,b = found()
		ans = exe(a,b)
	print(ans)
