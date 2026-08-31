n, m = tuple(map(int, input().split()))
s = set()
for i in range(n):
    s |= (set(list(map(int, input().split()))[1:]))
    
se = set([i for i in range(1,m + 1)])
if s == se:
    print('YES')
else:
    print('NO')
    