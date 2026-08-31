a, b = [int(x) for x in input().split()]
hours = a

while a > 0:
    hours += a//b
    a = a//b + a%b
    if a <= b:
        if a == b:
            hours += 1
        break

print(hours)
