N, M = map(int, input().split())
A = set([int(input()) for i in range(M)])
B = [0]*(N+1)
B[0] = 1
for i in range(1, N+1):
    B[i] = B[i-1] + B[i-2]
    if i in A:
        B[i] = 0
print(B[N]%1000000007)