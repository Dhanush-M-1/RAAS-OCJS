a, b = map(int, input().split())

hours = 0
left = a

while left > 0:
    hours += 1
    left -= 1

    if hours % b == 0:
        left += 1

print(hours)