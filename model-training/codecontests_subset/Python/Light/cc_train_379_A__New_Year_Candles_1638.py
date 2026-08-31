a, b = map(int, input().split())
h = 0
x = a
y = b
while x > 0:
    h += 1
    x -= 1
    y -= 1
    if y == 0:
        x += 1
        y = b
print(h)
