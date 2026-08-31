n, m = list(map(int, input().split()))
s = []
for i in range(n):
    s.extend(list(map(int, input().split()))[1:])
if len(set(s)) == m:
    print('YES')
else:
    print('NO')