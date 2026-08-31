N, M = map(int, input().split())
stairs = [1] * (N+1)
for m in range(M):
    a = int(input())
    stairs[a] = 0
for n in range(2, N+1):
    stairs[n] = (stairs[n-1] + stairs[n-2])*stairs[n]
print(stairs[N]%1000000007)