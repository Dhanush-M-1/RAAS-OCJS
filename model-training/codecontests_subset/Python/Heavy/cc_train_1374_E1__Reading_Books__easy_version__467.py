n, k = map(int, input().split())
times = [[], [], [], []]
for i in range(n):
    t, a, b = map(int, input().split())
    times[a * 2 + b].append(t)
for i in range(1, 4):
    times[i].sort()
sums = []
for i in range(len(times)):
    sums.append([])
    for j in range(len(times[i])):
        if j == 0:
            sums[i].append(times[i][0])
        else:
            sums[i].append(times[i][j] + sums[i][j - 1])
sums[1].insert(0, 0)
sums[2].insert(0, 0)
sums[3].insert(0, 0)
ans = 10 ** 10
for i in range(min(k + 1, len(sums[-1]))):
    if k - i < len(sums[1]) and k - i < len(sums[2]):
        ans = min(ans, sums[3][i] + sums[1][k - i] + sums[2][k - i])
if ans == 10 ** 10:
    ans = -1
print(ans)
