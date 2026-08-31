vals = list(input().split(' '))
a = int(vals[0])
b = int(vals[1])
h = 0
uA = 0

while a:
    h += 1
    uA += 1
    a -= 1
    if uA == b:
        a += 1
        uA = 0

print(h)
