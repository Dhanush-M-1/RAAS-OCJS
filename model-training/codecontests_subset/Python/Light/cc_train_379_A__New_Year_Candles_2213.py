a, b = map(int, input().split())
hours = a
while a >= b:
    leftover = a % b
    a = a // b
    hours += a
    a += leftover
print(hours)
