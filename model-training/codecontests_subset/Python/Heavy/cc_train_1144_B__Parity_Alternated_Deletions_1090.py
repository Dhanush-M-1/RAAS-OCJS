n = int(input())
b = list(map(int, input().split()))
b.sort(reverse=True)
x = 0
y = 0
for i in b:
    if i % 2 == 0:
        x += 1
    else:
        y += 1
if x == y or x == y + 1 or y == x + 1:
    print(0)
elif x == 0 or y == 0:
    print(sum(b)-b[0])
elif x > y:
    x = x - y - 1
    y = 0
    for i in range (len(b) - 1, -1, -1):
        if b[i] % 2 == 0:
            y += b[i]
            x -= 1
        if x == 0:
            break
    print(y)
elif x < y:
    y = y - x - 1
    x = 0
    for i in range (len(b) - 1, -1, -1):
        if b[i] % 2 == 1:
            x += b[i]
            y -= 1
        if y == 0:
            break
    print(x)
