n, k = map(int, input().split())

t = []
a = []
b = []
n1 = 0
n2 = 0
n3 = 0
for _ in range(n):
    x, y, z = map(int, input().split())
    if y == 1 and z == 1:
        t.append(x)
        n1 += 1
    elif y == 1:
        a.append(x)
        n2 += 1
    elif z == 1:
        b.append(x)
        n3 += 1

t.sort()
a.sort()
b.sort()
nc = min(n2, n3)
c = [a[i] + b[i] for i in range(min(n2, n3))]

ans = 0
i = 0
j = 0
while i < n1 and j < nc and k > 0:
    if t[i] <= c[j]:
        i += 1
        ans += t[i - 1]
    else:
        j += 1
        ans += c[j - 1]
    k -= 1
    if k == 0:
        break

while k > 0 and i < n1:
    i += 1
    ans += t[i - 1]
    k -= 1

while k > 0 and j < nc:
    j += 1
    ans += c[j - 1]
    k -= 1

if k > 0:
    print(-1)
else:
    print(ans)