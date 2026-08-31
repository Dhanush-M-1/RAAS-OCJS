p = 1000000007

n, m = map(int, input().split())

u = [0]*(n+1)
F = [0]*(n+1)
for i in range(m):
	x = int(input())
	u[x] = 1

F[0] = 1
for i in range(1, n+1):
	F[i] = (F[i-1]+F[i-2])%p
	if u[i] == 1: F[i] = 0

print(F[n])
