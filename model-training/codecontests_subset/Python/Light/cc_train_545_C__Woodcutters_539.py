n = int(input())
h = []
x = []
for i in range(n):
    a, b = map(int, input().split())
    x.append(a)
    h.append(b)
last = x[0]
t = 1
for i in range(1, n - 1):
    if last < x[i] - h[i]:
        t += 1
        last = x[i]
    elif x[i] + h[i] < x[i + 1]:
        t += 1
        last = x[i] + h[i]
    else:
        last = x[i]
if n > 1:
    t += 1
print(t)