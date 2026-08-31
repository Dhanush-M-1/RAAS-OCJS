def solve(A):
	plays = 0
	clears = 0

	for index in A:
		P = index[0]
		C = index[1]

		newPlays = P - plays
		newClears = C - clears

		if newPlays < 0 or newClears < 0 or newPlays < newClears:
			return False

		plays = P
		clears = C

	return True

def convertArrayToInt(A):
	for i in range(0, len(A), 1):
		A[i] = int(A[i])

	return A


testCases = int(input())

while testCases:	
	n = int(input())

	indices = []
	while n:
		X = input().split()
		X = convertArrayToInt(X)

		indices.append([X[0], X[1]])
		n-=1

	ans = solve(indices)
	if ans:
		print("YES")
	else:
		print("NO")

	testCases-=1