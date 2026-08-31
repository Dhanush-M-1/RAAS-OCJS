a, b = map(int, input().split())
c = a
while a // b >= 1:
    c += a // b
    a = a % b + a // b
print(c)