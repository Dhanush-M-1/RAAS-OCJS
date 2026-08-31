inp = lambda: map(int, input().rstrip().split())
li = []
n = int(input())
for i in range(n):
    li += [list(inp())]
li.sort(key=lambda x: x[0])
last = li[0][0]
c = min(2, n)
for i in range(1, n - 1):
    x = li[i][0]
    y = li[i][1]
    z = li[i + 1][0]
    if x - y > last:
        last = x
        c += 1
    elif x + y < z:
        last = x + y
        c += 1
    else:
        last = x
print(c)