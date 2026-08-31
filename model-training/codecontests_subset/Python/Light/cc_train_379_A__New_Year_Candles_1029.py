a, b = map(int, input().split())

candel = a
while a >= b:
    candel += a // b
    a = a % b + a // b

print(candel)