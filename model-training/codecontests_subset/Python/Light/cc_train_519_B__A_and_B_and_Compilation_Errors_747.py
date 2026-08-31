n = int(input())
a = str(input()).split()
b = str(input()).split()
c = str(input()).split()
x = y = 0


for i in range(n):
    a[i] = int(a[i])
for i in range(n-1):
    b[i] = int(b[i])
for i in range(n-2):
    c[i] = int(c[i])

a.sort()
b.sort()
c.sort()

for i in range(n):
    if i <= n - 2 and x == 0:
        if a[i] != b[i]:
            x = a[i]
    if i == n - 1 and x == 0:
        x = a[n-1]
    if i <= n - 3 and y == 0:
        if b[i] != c[i]:
            y = b[i]
    if i == n - 2 and y == 0:
        y = b[n-2]
    if x != 0 and y != 0:
        break

print(x)
print(y)
