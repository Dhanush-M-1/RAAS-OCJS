from math import inf

n = int(input())
a = []
for i in range(n):
    x, h = map(int, input().split())
    a.append([x, h])

a.append([inf, inf])

count = 0
prev = -inf
for i in range(n):
    x, h = a[i]
    if prev < x - h:
        count += 1
        prev = x
    elif x + h < a[i + 1][0]:
        count += 1
        prev = x + h
    else:
        prev = x
print(count)
