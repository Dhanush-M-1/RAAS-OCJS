n = int(input())
x1, h1 = map(int, input().split())
ans = 1
prev = 1
for i in range(1, n):
    x2, h2 = map(int, input().split())
    if not prev:
        if x1 + h1 < x2:
            ans += 1
            x1 += h1
    if x2 - h2 > x1:
        ans += 1
        prev = 1
    else:
        prev = 0
    x1, h1 = x2, h2
if not prev:
    ans += 1
print(ans)