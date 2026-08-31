a, b = map(int, input().split())
h = 0
x = 0
y = 0

while a:
    h += 1
    a -= 1
    x += 1
    if (x == b):
        a += 1
        x = 0
print(h)
