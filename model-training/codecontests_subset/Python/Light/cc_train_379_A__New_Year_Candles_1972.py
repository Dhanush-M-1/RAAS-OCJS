a, b = map(int, input().split()); h = a
while a >= b:
    h += a // b
    a = a // b + a % b
print(h)