n = int(input())
res = 1
x, h = list(map(int, input().split()))
right = x
for i in range(n - 1):
    x_old = x
    x, h = list(map(int, input().split()))
    if x <= right:
        right = x_old
        res -= 1
    res += 1
    # проверить, можно ли дерево положить влево (тогда right = x)
    if x - h > right:
        right = x
    # иначе
    else:
        right = x + h
print(res)
