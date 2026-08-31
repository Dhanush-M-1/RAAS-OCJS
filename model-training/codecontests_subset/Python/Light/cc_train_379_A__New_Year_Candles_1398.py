import math

a, b = map(int, input().split())

t = 0
c = 0

while c >= b or a:
    t += a
    c += a
    a = math.floor(c / b)
    c = c % b

print(t)