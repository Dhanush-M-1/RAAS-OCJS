a, b = map(int, input().split())
total = a
while a >= b:
    total += a//b
    a = a // b + a % b
print(total)