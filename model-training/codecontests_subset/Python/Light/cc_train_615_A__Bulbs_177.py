l = list(input().split())
n = int(l[0])
m = int(l[1])
s = {0}
for i in range(n):
    a = list(input().split())
    a = [int(j) for j in a]
    for k in range(1, a[0] + 1):
        s.add(a[k])
if sum(s) != (((m + 1) * m) // 2):
    print("NO")
else:
    print("YES")