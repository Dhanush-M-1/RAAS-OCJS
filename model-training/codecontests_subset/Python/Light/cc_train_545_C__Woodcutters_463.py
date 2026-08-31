n = int(input())
a = []
for _ in range(n):
    x, h = map(int, input().split())
    a.append([x, h])

a.sort(key = lambda x : x[0])

ans = 0
left = -1e10
a.append([1e10, 0])
for i in range(n):
    if a[i][0] - a[i][1] > left:
        ans += 1
        left = a[i][0]
    elif a[i][0] + a[i][1] < a[i+1][0]:
        ans += 1
        left = a[i][0] + a[i][1]
    else:
        left = a[i][0]

print(ans)