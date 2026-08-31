a, b = map(int, input().split())
burnt = 0
hours = a
while a >= b:
    hours += a // b
    a = a // b + a % b
print(hours)




