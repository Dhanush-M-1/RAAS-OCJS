import math
n = int(input())
for i in range(n):
    z = int(input())
    c = 0
    if math.log(z, 6) % 1 == 0:
        c = math.log(z, 6)
    elif math.log(z, 3) % 1 == 0:
        c = math.log(z, 3) * 2
    else:
        c = math.floor(math.log(z, 6))
        z /= 6 ** c
        while z != 1:
            # print(z * 2 ** c)
            if z % 6 == 0:
                z /= 6
                c += 1
            elif (z * 2 ** c) % 3 == 0:
                z *= 2
                c += 1
            else:
                c = -1
                break
    print(int(c))
