n, k = [int(x) for x in input().split()]
a = [int(x) for x in input().split()]
mini = 1000
for i in range(n):
    q = k / a[i]
    if int(q) == q:
        if q < mini:
            mini = q
print(int(mini))