n, m = map(int, input().split())
a = [0] * m
for i in range(n):
    x, *y = map(int, input().split())
    for j in y:
        a[j - 1] = 1
print('NO' if 0 in a else 'YES')
