n = int(input())

a = list(list(map(lambda x: int(x), list(input().split(' ')))) for i in range(n))

curr = a[0][0]
ans = 1


for i in range(1, n):
    if a[i][0] - a[i][1] > curr:
        ans += 1
        curr = a[i][0]
    elif (i == n - 1) or (a[i][0] + a[i][1] < a[i + 1][0]):
        ans += 1
        curr = a[i][0] + a[i][1]
    else:
        curr = a[i][0]

print(ans)