n = int(input())
a = []

for i in range(n):
    a.append([int(i) for i in input().split()])

predk = a[0][0]
if n >= 2:
    sm = 2
else:
    sm = n
for i in range(1, n - 1):
    if predk < a[i][0] - a[i][1]:
        sm += 1
        predk = a[i][0]
    elif a[i][0] + a[i][1] < a[i + 1][0]:
        sm += 1
        predk = a[i][0] + a[i][1]
    else:
        predk = a[i][0]

print(sm)