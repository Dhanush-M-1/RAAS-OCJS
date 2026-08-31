N,M = map(int,input().split())
D = [1]*(N+1) #0段目からn段目まで
MOD = 10**9 + 7

for _ in range(M):
    D[int(input())] = 0

for i in range(N+1):
    if i <2 or D[i] == 0:
        continue
    D[i] = (D[i-1] + D[i-2]) % MOD

print(D[i])