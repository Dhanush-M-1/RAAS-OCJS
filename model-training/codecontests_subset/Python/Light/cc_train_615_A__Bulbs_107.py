n, m = map(int, input().split())
n, m = m, n
lamps = [0] * n
for i in range(m):
    s = list(map(int, input().split()))
    s = s[1:]
    for j in s:
        lamps[j - 1] = 1
ans = "YES"
for i in lamps:
    if i == 0:
        ans = "NO"
print(ans)