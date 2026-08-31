def readInput():
	Q = int(input()) 	
	lista = list()
	for i in range(Q):
		l, r, d = map(int, input().split())
		lista.append([l, r, d]) 
	return Q, lista

def solve(l, r, d):
	upValue = r // d + 1
	downValue = (l + d - 1) // d - 1
	if (downValue <= 0):
		return upValue * d
	else:
		return d

def solveProblem():
	Q, queries = readInput()
	assert Q == len(queries) 
	for i in range(Q):
		print(solve(queries[i][0], queries[i][1], queries[i][2]))
	
		
solveProblem() 	