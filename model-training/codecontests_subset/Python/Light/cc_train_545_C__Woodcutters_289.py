n, k = int(input()), 2
if n < 2:
    print(1),exit()
a = [[int(i) for i in input().split()] for _ in range(n)]
for i in range(1, n - 1):
    if a[i][0] - a[i][1] > a[i - 1][0]:
        k += 1
    elif a[i][0] + a[i][1] < a[i + 1][0]:
        a[i][0] += a[i][1]
        k += 1
print(k)