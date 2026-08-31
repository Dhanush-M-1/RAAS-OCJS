N,M = map(int, input().split())
As = [1] *( N+1)
mod = 10**9+7
for _ in range(M):
    i = int(input())
    As[i] = 0
for i in range(N-1):
    if As[i+2] > 0:
        As[i+2] = As[i+1] + As[i]
print(As[-1]%mod)