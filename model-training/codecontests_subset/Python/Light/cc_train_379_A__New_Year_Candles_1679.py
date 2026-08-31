[a, b] = [int(x) for x in input().split()]

hours = 1
while a > 0:
    a -= 1
    if hours % b == 0:
        a += 1
    hours += 1

hours -= 1

print(hours)

