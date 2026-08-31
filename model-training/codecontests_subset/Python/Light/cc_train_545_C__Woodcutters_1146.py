n = int(input())
a = [tuple(int(x) for x in input().split()) for _ in range(n)]

s = 0
r = False

for i in range(n):
    if i == 0 or a[i][0] - a[i][1] > (a[i - 1][0] + (a[i - 1][1] if r else 0)):
        s += 1
        r = False
    elif i == n - 1 or a[i][0] + a[i][1] < a[i + 1][0]:
        s += 1
        r = True
    else:
        r = False

print(s)
