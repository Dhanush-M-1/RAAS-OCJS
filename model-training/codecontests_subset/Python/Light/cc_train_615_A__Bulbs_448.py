from collections import Counter
n, m = map(int, input().split())
c = Counter()
for i in range(n):
    l, *arr = list(map(int, input().split()))
    c.update(arr)
if len(c) == m:
    print('YES')
else:
    print('NO')
