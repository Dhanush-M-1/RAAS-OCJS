def main():
	(n, p, w, d) = (int(x) for x in input().split())
	result = solver(n, p, w, d)
	if result == -1:
		print(-1)
	else:
		print(*result)

def solver(n, p, w, d):
	maxScore = w * n
	if maxScore < p:
		return -1
	if p % gcd(w, d) != 0:
		return -1
	if p < d and p > 0:
		return -1
	maxWins = p // w
	for i in range(min(maxWins + 1, d)):
		if (p - (maxWins - i) * w) % d == 0:
			wins = maxWins - i
			draws = (p - (maxWins - i) * w) // d
			losses = n - wins - draws
			return (wins, draws, losses)
	return -1

def gcd(x, y):
	(x, y) = (max(x, y), min(x, y))
	while y != 0:
		(x, y) = (y, x % y)
	return x

#print(*solver(30, 60, 3, 1))
#print(solver(10, 51, 5, 4))
#print(solver(20, 0, 15, 5))
#print(*(1, 2, 3, 4))
#print(solver(10, 2, 5, 3))

main()