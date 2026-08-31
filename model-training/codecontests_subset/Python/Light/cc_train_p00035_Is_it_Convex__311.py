def is_on_the_same_side(p0, p1, p2, p3):
    s2 = (p1[0]-p0[0]) * (p2[1]-p0[1]) - (p2[0]-p0[0]) * (p1[1]-p0[1])
    s3 = (p1[0]-p0[0]) * (p3[1]-p0[1]) - (p3[0]-p0[0]) * (p1[1]-p0[1])
    if s2 * s3 > 0:
        return True
    else:
        return False

while True:
    try:
        data = list(map(float, input().split(',')))
        a = data[0:2]
        b = data[2:4]
        c = data[4:6]
        d = data[6:8]

        if not is_on_the_same_side(a, c, b, d) and is_on_the_same_side(b, c, a, d) and is_on_the_same_side(a, b, c, d):
            print('YES')
        else:
            print('NO')
    except:
        break