n, m = [int(i) for i in input().split()]
ar = m * [False]
for _ in range(n):
    br = [int(i) for i in input().split()]
    for j in br[1:]:
        ar[j-1] = True

if False in ar:
    print('NO')
else:
    print('YES')