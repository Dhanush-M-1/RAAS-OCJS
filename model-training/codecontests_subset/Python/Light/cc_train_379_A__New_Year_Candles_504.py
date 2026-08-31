a, b = map(int, input().split())
d = a
t = 0
while a >= b:
    c = a // b
    e = a - b * c
    a = c + e
    t += e
    d += c
print(d)