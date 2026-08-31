n, k = map(int, input().split())
res = 0
a = []
b = []
dp = []
for i in range(n):
    t, x, y = map(int, input().split())
    if x == y == 1:
        dp.append(t)
    elif x == 1:
        a.append(t)
    elif y==1:
        b.append(t)
a.sort()
b.sort()
for i in range(min(len(a), len(b))):
    dp.append(a[i] + b[i])
dp.sort()
if len(dp) < k:
    print(-1)
else:
    print(sum(dp[:k]))
