m, n = map(int, input().split())
s = []
for i in range(m):
    a = [int(x) for x in input().split()]
    a.remove(a[0])
    s += a
S = set(s)
print('YES' if(len(S) == n) else 'NO')