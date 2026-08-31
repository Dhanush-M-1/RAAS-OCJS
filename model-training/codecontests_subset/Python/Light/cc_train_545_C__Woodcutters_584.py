n = int(input())
#n, m = map(int, input().split())
#s = input()
a = []
for i in range(n):
    c = list(map(int, input().split()))
    a.append(c)
l = min(2, n)
for i in range(1, n - 1):
    if a[i - 1][0] < a[i][0] - a[i][1]:
        l += 1
    else:
        if a[i][0] + a[i][1] < a[i + 1][0]:
            a[i][0] += a[i][1]
            l += 1
print(l)