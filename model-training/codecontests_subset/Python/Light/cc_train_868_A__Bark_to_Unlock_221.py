p = input()
n = int(input())
a = [0] * n
for i in range(n):
    a[i] = input()

fl = False
for i in range(n):
    for j in range(n):
        if a[i] == p or a[j] == p or a[i][1] + a[j][0] == p:
            fl = True
            break

if fl:
    print("YES")
else:
    print("NO")