a, b = list(map(int, input().split()))
hours = 0
while a >= b:
    hours += b
    a = a - b + 1
hours += a
print(hours)