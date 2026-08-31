m,n = map(int,input().split())

l = []
for i in range(m):
    l += input().split()[1:]

s = set(l)
l2 = list(s)

if len(l2) == n:
    print('YES')
else:
    print('NO')