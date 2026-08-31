N, M = map(int, input().split())
DP = [1 for i in range(N+1)]
MOD = 10**9 + 7

for i in range(M):
    DP[int(input())] = 0

for i in range(2,N+1):
    
    if (DP[i] != 0):
        DP[i] = DP[i-1] + DP[i-2]
print(DP[N]%MOD)