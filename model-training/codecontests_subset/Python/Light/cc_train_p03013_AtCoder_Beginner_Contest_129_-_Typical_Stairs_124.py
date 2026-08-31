N, M = map(int, input().split())
A = [int(input()) for _ in range(M)]

B = set(A)

X = [1, 1 if 1 not in B else 0]
for i in range(2, N + 1):
    x = (X[-1] + X[-2]) % 1000000007
    X.append(x if i not in B else 0)

print(X[N])
