n = int(input())
b = list(map(int,input().split()))
a = [[0] * 2 for i in range(n)]
for i in range(n):
    a[i][0] = b[i]
    a[i][1] = i
for i in range(n-1):
    for j in range(n-i-1):
        if a[j][0] > a[j+1][0]:
            a[j], a[j+1] = a[j+1], a[j]
        elif (a[j][0] == a[j + 1][0]) and (a[j][1] < a[j + 1][1]):
            a[j], a[j+1] = a[j+1], a[j]
m = int(input())
for k in range(m):
    k, ind = map(int,input().split())
    ans = [[0] * 2 for i in range(k)]
    for i in range(k):
        ans[i][0] = a[n - i - 1][1]
        ans[i][1] = a[n - i - 1][0]
    ans.sort()
    print(ans[ind - 1][1])
