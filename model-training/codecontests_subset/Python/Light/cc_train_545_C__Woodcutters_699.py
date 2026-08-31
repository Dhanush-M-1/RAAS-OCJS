n = int(input())
a = []
for i in range(n):
    a.append([int(x) for x in input().split()])
last = -1000000001
res = 0
for i in range(n-1):
    if a[i][0] - a[i][1] > last:
        last = a[i][0]
        res += 1
    elif a[i][0] + a[i][1] < a[i+1][0]:
        last = a[i][0] + a[i][1]
        res += 1
    else:
        last = a[i][0]
res += 1
print(res)
