n, m = map(int, input().split())
a = [int(input()) for _ in range(m)]
b = [1]*(n + 1)

for i in a:
    b[i] = 0

for i in range(2, n + 1):
    if b[i] != 0:
        b[i] = b[i - 2] + b[i - 1]

print(b[-1]%(10**9 + 7))