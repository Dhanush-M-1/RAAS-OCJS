import sys
n = int(input())
a = [];
for i in range(0, n):
    x,h  = map(int, input().split())
    a.append([x,h])
lp = - (10 ** 10);
ans = 1
for i in range(0, n - 1):
    if a[i][0] - a[i][1] > lp:
        ans +=1
        lp = a[i][0] - a[i][1]
    else:
        if a[i][0] + a[i][1] < a[i + 1][0]:
            ans += 1
            lp = a[i][0] + a[i][1]
    lp = max(lp, a[i][0])
            
print(ans)
