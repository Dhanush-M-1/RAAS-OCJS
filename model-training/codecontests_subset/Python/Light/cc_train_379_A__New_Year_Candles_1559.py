a, b = [int(x) for x in input().split()]
hour = 0
while a >= 1:
    hour += 1
    a -= 1
    if hour % b == 0:
        a += 1
print(hour)