n, k = [int(x)for x in input().split()]

s = set()
for i in range(n):
    arr = [int(x)for x in input().split()]
    s.update(arr[1:])

if len(s) >= k: print('YES')
else: print('NO')