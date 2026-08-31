n = int(input())
a = []
for i in range(n):
    a.append(tuple(map(int, input().split())))
if n > 1:
    ans = 2
    rast = a[1][0] - a[0][0]
    for i in range(1, n-1):
        if a[i][1] < rast:
            ans += 1
            rast = a[i+1][0] - a[i][0]
        elif a[i][1] < a[i+1][0] - a[i][0]:
            ans += 1
            rast = a[i+1][0] - a[i][0] - a[i][1]
        else:
            rast = a[i+1][0] - a[i][0]
    print(ans)        
else:
    print(1)