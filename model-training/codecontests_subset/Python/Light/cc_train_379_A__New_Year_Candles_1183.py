a, b = (int(i) for i in input().split())

hours = 0
old = 0
while a > 0:
    hours += 1
    a -= 1
    old += 1
    if old == b:
        a += 1
        old = 0

print(hours)