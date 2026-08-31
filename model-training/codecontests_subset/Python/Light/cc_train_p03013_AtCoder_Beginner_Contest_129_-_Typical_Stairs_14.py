N,M = map(int,input().split())
step = [1]*(N+1)
for _ in range(M):
	A = int(input())
	step[A] = 0

for i in range(2,N+1):
	if step[i] == 0:
		continue
	step[i] = (step[i-1] + step[i-2])%(10**9+7)

print(step[-1]%(10**9+7))