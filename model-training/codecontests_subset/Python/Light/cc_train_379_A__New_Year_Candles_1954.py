a, b = map(int, input().split())
h, r = a, 0
while a:
    r += a % b
    a = a//b
    h += a
    if r >= b:
        h += r//b
        r = r % b
        a += 1
print(h)