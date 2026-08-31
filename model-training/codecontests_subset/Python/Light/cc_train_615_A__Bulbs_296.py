n, m = map(int, input().split())
sett = set()
for i in range(n):
    x = list(map(int, input().split()))
    for j in range(1, len(x)):
        sett.add(x[j])
if len(sett) == m:
    print('YES')
else:
    print('NO')
