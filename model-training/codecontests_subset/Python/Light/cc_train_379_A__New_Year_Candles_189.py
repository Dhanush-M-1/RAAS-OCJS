temp = input().split()
a = int(temp[0])
b = int(temp[1])
h = 0
p = 0
while a > 0:
    a -= 1
    p += 1
    if p == b: a += 1; p = 0
    h += 1
print(h)
