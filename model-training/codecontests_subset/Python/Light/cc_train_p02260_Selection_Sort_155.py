p = int(input())
y = list(map(int, input().split()))
t = 0
for h in range(p):
    o = h
    for n in range(h, p):
        if y[n] < y[o]: o = n
    if h != o:
        y[h], y[o] = y[o], y[h]
        t += 1
print(*y)
print(t)