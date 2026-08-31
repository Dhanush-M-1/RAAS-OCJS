n = int(input())
li = []
for i in range(n):
    r = list(map(int, input().split()))
    li.append(r)
t = 1
last = li[0][0]
for i in range(1, n - 1):
    if li[i][0] - li[i][1] > last:
        t += 1
        last = li[i][0]
    elif li[i][0] + li[i][1] < li[i + 1][0]:
        t += 1
        last = li[i][0] + li[i][1]
    else:
        last = li[i][0]
if n > 1:
    t += 1
print(t)