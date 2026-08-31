a, b = map(int, input().split())
hours = 0
while a != 0:
    hours += 1
    a -= 1
    if hours % b == 0:
        a += 1
print(hours)