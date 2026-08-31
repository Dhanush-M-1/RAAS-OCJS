a, b = map(int, input().split())

out = 0
total = 0

while a > 0:
    total += a
    out += a
    a = 0

    a += int(out / b)
    out -= a * b

print(total)