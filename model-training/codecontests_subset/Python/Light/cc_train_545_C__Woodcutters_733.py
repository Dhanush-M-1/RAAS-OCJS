n = int(input())
f = [[*map(int, input().split())] for i in range(n)]
current = f[0][0]
ans = 0
for i in range(1, n - 1):
    if f[i][0] - current > f[i][1]:
        current = f[i][0]
        ans += 1
        continue
    if sum(f[i]) < f[i + 1][0]:
        current = sum(f[i])
        ans += 1
        continue
    current = f[i][0]
print(min(n, ans + 2))