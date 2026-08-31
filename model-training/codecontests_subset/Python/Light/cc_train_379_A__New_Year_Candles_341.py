a, b = map(int, input().split(' '))
cou = a
while a >= b:
    cou += a // b
    a = a // b + a % b
print(cou)