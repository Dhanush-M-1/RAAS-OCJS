n, m = map(int, input().split())
lt = [False] * (m + 1)
lt[0] = True
for i in range(n):
    b = list(map(int, input().split()))
    for j in range(1, len(b)):
        lt[b[j]] = True
print('YES' if all(lt) else 'NO')