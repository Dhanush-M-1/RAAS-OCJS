a, b = map(int, input().split())
i = 0

while a > 0:
    i += 1
    a -= 1
a = i
while a > 0 and a >= b:
    i = i + a // b
    a = a // b + a % b
print(i)

