a, b = map(int, input().split())
hours, c = 0, 0
while a > 0:
    a -= 1
    hours += 1
    c += 1
    if c == b:
        a += 1
        c = 0
print(hours)