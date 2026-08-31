from math import log

def rk(x, y, z):
    if x <= 1 and y <= 1 and z <= 1:
        return rk1(x, y, z)
    else:
        return rk2(x, y, z)

def rk1(x, y, z):
    if x == 1:
        return 'x^y^z'
    elif y == 1:
        return 'y^x^z'
    elif z == 1:
        return 'z^x^y'

    lx = log(x)
    ly = log(y)
    lz = log(z)
    l2x = log(-lx)
    l2y = log(-ly)
    l2z = log(-lz)
    a = [
        (z*ly + l2x,    'x^y^z'),
        (y*lz + l2x,    'x^z^y'),
        (ly + lz + l2x, '(x^y)^z'),
        (z*lx + l2y,    'y^x^z'),
        (x*lz + l2y,    'y^z^x'),
        (lz + lx + l2y, '(y^x)^z'),
        (y*lx + l2z,    'z^x^y'),
        (x*ly + l2z,    'z^y^x'),
        (ly + lx + l2z, '(z^x)^y'),
    ]
    return min(a, key=lambda t:t[0])[1]


def rk2(x, y, z):
    lx = log(x)
    ly = log(y)
    lz = log(z)

    a = []

    if x > 1:
        l2x = log(lx)
        a += [
            (z*ly + l2x,    'x^y^z'),
            (y*lz + l2x,    'x^z^y'),
            (ly + lz + l2x, '(x^y)^z'),
        ]

    if y > 1:
        l2y = log(ly)
        a += [
            (z*lx + l2y,    'y^x^z'),
            (x*lz + l2y,    'y^z^x'),
            (lz + lx + l2y, '(y^x)^z'),
        ]

    if z > 1:
        l2z = log(lz)
        a += [
            (y*lx + l2z,    'z^x^y'),
            (x*ly + l2z,    'z^y^x'),
            (ly + lx + l2z, '(z^x)^y'),
        ]

    return max(a, key=lambda t:t[0])[1]


if __name__ == '__main__':
    x, y, z = map(float, input().split())
    print(rk(x, y, z))
