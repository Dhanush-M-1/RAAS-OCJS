import sys

p = (sys.stdin.readline().strip().split(' '))

h = 0
a = int(p[0])
b = int(p[1])
m = 0

while (a+m) >= b:
    h = h + a
    t = (a + m) // b
    m = (a + m) % b
    a = t

print(h + a)
