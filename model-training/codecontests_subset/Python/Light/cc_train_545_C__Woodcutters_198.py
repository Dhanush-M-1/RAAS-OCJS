n = int(input())
xs = [0] * n
hs = [0] * n
for i in range(n):
    x, h = map(int, input().split())
    xs[i] = x
    hs[i] = h

pos = -float('inf')
xs.append(float('inf'))
count = 0
for i in range(n):
    x = xs[i]
    x1 = xs[i + 1]
    h = hs[i]
    if x - h > pos:
        count += 1
        pos = x
    elif x + h < x1:
        count += 1
        pos = x + h
    else:
        pos = x
print(count)