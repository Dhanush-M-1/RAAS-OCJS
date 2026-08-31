a, b = input().split()
a, b = int(a), int(b)
x = 0
while a >= b:
  x += a - a % b
  a = a // b + a % b
x += a
print(x)