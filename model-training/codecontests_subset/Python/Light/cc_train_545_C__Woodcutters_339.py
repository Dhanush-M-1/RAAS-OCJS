n = int(input())
l = [list(map(int, input().split())) for i in range(n)]
res = 2
for e in range(1, n-1):
    x, h = l[e]
    if x - h > l[e-1][0]:
        res += 1
    elif x + h < l[e+1][0]:
        res += 1
        l[e][0] += h
print(res if n > 1 else 1)