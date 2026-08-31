a, b = [int(i) for i in input().split()]
c = 0
d = 0
while a > 0:
    c += a
    a, d = (a+d) // b, (a+d) % b
print(c)