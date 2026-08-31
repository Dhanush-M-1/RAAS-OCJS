t = int(input())
for i in range(t):
    n = int(input())
    a = []
    ans = 'YES'
    for j in range(n):
        x, y = map(int, input().split())
        a.append([x, y])
        if j > 0:
            if a[j][0] < a[j - 1][0]:
                ans = 'NO'
            if a[j][1] < a[j - 1][1]:
                ans = 'NO'
            if a[j][0] < a[j][1]:
                ans = 'NO'
            if a[j][0] - a[j - 1][0] < a[j][1] - a[j - 1][1]:
                ans = 'NO'
        else:
            if a[j][0] < a[j][1]:
                ans = 'NO'
    print(ans)
