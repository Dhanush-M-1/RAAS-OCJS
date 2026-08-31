n, m = map(int, input().split())
a = [0] * m
for u in range(n):
    b = [int(i) for i in input().split()]
    for i in range(b[0]):
        a[b[i + 1] - 1] = 1
if sum(a) == m:
    print("YES")
else:
    print("NO")