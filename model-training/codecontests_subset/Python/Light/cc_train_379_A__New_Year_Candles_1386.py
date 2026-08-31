a, b = map(int, input().split())

hours = 0
used = 0

while a > 0:
    hours += 1
    used += 1
    a -= 1
    if used >= b:
        used -= b
        a += 1

print(hours)