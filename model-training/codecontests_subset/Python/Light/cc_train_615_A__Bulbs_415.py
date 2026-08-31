n, m = map(int, input().split())
s = set()

for i in range(n):
    l = list(map(int, input().split()))
    l.remove(l[0])
    s.update(set(l))

if len(s) == m:
    print('YES')

else:
    print('NO')
