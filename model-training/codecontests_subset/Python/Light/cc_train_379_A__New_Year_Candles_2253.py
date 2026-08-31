s = input().split()
a = int(s[0])
b = int(s[1])
c = 0
h = 0
while a > 0:
    a -= 1
    c += 1
    h += 1
    if c == b:
        a += 1
        c -= b
print(h)
