N, M=map(int, input().split())
A = [int(input()) for _ in range(M)]
mod = 10**9 + 7
step = [1]*(N+1)

for a in A:
    step[a]=0
for i in range(2, N+1):
    step[i]=(step[i-1]+step[i-2])%mod*step[i]
print(step[-1])