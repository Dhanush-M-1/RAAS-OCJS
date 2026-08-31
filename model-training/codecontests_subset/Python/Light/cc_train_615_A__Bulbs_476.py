[n, m] = [int(x) for x in input().split()]
L = set()
for i in range(n):
    I = [int(x) for x in input().split()]
    I.remove(I[0])
    L = L.union(set(I))
print('YES' if L == {(i+1) for i in range(m)} else 'NO')
