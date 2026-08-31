import math
while True:
    try:
        xa, ya, xb, yb, xc, yc, xd, yd = map(float, input().split(','))
    except:
        break
    vecs = [(xb - xa, yb - ya), (xc - xb, yc - yb), (xd - xc, yd - yc), (xa - xd, ya - yd)]
    angles = [(math.atan2(*vecs[(i + 1) % 4][::-1]) - math.atan2(*vecs[i][::-1])) % (2 * math.pi) for i in range(4)]
    print('YES' if max(angles) < math.pi or min(angles) > math.pi else 'NO')