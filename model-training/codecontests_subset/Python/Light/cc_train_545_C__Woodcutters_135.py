from sys import stdin

N = int(stdin.readline())
X, H = tuple(map(list, tuple(zip(*tuple(tuple(map(int, stdin.readline().strip().split())) for n in range(N))))))

H[0] = 0
H[-1] = 0

for i in range(1, len(X) - 1):
	if H[i] < X[i] - X[i - 1]:
		H[i] = 0
	elif H[i] < X[i + 1] - X[i]:
		X[i] += H[i]
		H[i] = 0

print(sum(k == 0 for k in H))
