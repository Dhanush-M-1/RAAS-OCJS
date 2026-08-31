a, b = [int(x) for x in input().split()]
hours = a
while int(a / b) != 0:
    hours += int(a / b)
    a = int(a / b) + a % b
print(hours)