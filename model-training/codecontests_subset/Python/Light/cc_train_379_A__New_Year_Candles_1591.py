anb = input().split()

a = int(anb[0])
b = int(anb[1])

time = a
Pos = True

while Pos:
    if a//b != 0:
        time += a // b
        a = a // b + a % b
    else:
        Pos = False

print(time)