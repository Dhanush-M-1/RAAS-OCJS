n, m = map(int, input().split())
s = set()
for i in range(n):
    a=list(map(int, input().split()))
    for j in range(1, len(a)):
        s.add(a[j])
if len(s)!=m:
    print('NO')
else:
    print('YES')