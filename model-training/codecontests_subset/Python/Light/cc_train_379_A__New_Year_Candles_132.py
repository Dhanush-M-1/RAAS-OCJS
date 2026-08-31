line = input().split()
a = int(line[0])
b = int(line[1])
c = 0
while True:
    if a >= b:
        c += b
        a = a - b + 1
    else:
        c += a
        break
print (c)