n = int(input())
k = 0
x = []
h = []
prev = -(10 ** 9)
for i in range(n):
    a, b = map(int, input().split())
    x.append(a)
    h.append(b)
for i in range(n):
    if i == 0:
        k += 1
        prev = x[i]
    elif i == n - 1:
        k += 1
    else:
        if x[i] - h[i] > prev:
            prev = x[i]
            k += 1
        elif x[i] + h[i] < x[i + 1]:
            prev = x[i] + h[i]
            k += 1
        else:
            prev = x[i]
print(k)
