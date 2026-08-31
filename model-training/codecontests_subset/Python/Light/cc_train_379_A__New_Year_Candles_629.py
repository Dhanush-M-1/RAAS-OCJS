a, b = [int(x) for x in input().split()]

hour = 1
broken = 0
while a != 0:
    a -= 1
    broken += 1
    if broken == b:
        broken = 0
        a += 1
    hour += 1

print(hour - 1)