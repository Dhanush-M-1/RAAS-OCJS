a = input().split()
n = int(a[0])
m = int(a[1])
b = [0] * m
for i in range(n):
    a = input().split()
    a[0] = int(a[0])
    for j in range(1 , a[0] + 1):
        a[j] = int(a[j])
        b[a[j] - 1] = 1
Dragon = True
for i in range(m):
    if b[i] == 0:
        Dragon = False
        break
if Dragon:
    print("YES")
else:
    print("NO")
