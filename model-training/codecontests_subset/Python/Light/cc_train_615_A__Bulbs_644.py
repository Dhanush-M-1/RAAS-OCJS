n, m = map(int, input().split())
x = set()

for _ in range(n):
    inp = list(map(int, input().split()))

    for i in range(1,inp[0]+1):
        x.add(inp[i])

if len(x) == m:
    print('YES')
else:
    print('NO')