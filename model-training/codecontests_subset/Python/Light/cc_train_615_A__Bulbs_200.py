n, m = map(int, input().split())

a = [0] * m

for _ in range(n):
    b = list(map(int, input().split()))
    for i in range(1, len(b)):
        a[b[i] - 1] = 1

print('YES' if sum(a) == m else 'NO')
