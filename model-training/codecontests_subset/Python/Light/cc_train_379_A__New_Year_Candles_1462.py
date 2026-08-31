[a, b] = [int(x) for x in input().split()]
hours = a
remain = 0
while a >= b:
    remain += a % b
    a = a//b
    hours += a
    if a < b:
        a += remain
        remain = 0
print(hours)
