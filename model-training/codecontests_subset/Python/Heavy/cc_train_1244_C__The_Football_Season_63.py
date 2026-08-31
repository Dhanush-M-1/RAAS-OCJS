import math
import sys
if __name__ == '__main__':
    [match, point, win, draw] = [int(z) for z in input().split()]
    def gcd(a, b):
        while b:
            a %= b
            a, b = b, a
        return a

    def extended_euclid(a, b):
        xx = 0
        y=  0
        yy = 1
        x = 1
        while b:
            q = a//b
            t = b
            b = a % b
            a = t
            t =xx
            xx = x - q * xx
            x=t
            t = yy
            yy= y- q * yy
            y=t
        return x, y


    def LinearDiophantine(a, b, c):
        d = gcd(a, b)
        if c % d != 0:
            return -1, -1
        x, y = extended_euclid(a, b)
        a //= d
        b //= d
        x *= c // d
        y *= c // d
        if x < 0 :
            kay = -x // b
            x = -((-x) % b)
            if x < 0:
                x += b
                kay += 1
            y -= a * kay

        if y < 0:
            kay = -y // a
            y = -((-y) % a)
            if y < 0:
                y += a
                kay += 1
            x -= b * kay
        if x < 0 or y  < 0:
            return x, y
    
        if x + y <= match:
            return x, y
        

        if b > a:
            kay = x // b
            x %= b
            y += a * kay
        else:
            kay = y // a
            y %= a
            x += b * kay 
        if x + y <= match:
            return x, y
        return -1, -1


    wi, dr = LinearDiophantine(win, draw, point)
    if wi < 0 or dr < 0:
        print(-1)
        exit(0)
    print('{} {} {}'.format(wi, dr, match - wi - dr))
