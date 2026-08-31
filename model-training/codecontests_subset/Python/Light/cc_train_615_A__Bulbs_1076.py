n, m = map(int, input().split())

ls = [False for i in range(m)]
for i in range(n):
    x, *ys = list(map(int, input().split()))
    for y in ys:
        ls[y-1] = True

for l in ls:
    if not l:
        print('NO')
        break
else:
    print('YES')
