n, m = map(int, input().split() )
L = [0] * (m+1)
for i in range(n):
    x, *a = map(int, input().split() )
    for v in a: L[v] = 1
print('YES' if sum(L) == m else 'NO')
