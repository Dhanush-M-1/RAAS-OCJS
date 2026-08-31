n, m = map(int, input().split())
mod = 1_000_000_007
A = [1] * (n+1)
for i in range(m):
    A[int(input())] = 0

for i in range(2, n+1):
    if A[i]!=0:
        A[i] = (A[i-1] + A[i-2])%mod

print(A[-1])