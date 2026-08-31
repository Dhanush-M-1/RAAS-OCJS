a, b = map(int, input().split())
hours = 0
while a > 0:
    a -= 1
    hours += 1
    if hours % b == 0:
        hours += 1
print(hours)