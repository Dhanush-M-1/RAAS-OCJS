def gcd(a, b):
    if b == 0:
        return a, 1, 0
    ret, x, y = gcd(b, a % b)
    xx = x; yy = y
    x = yy
    y = xx - a // b * yy
    return ret, x, y
 
def main():
    n, p, w, d = map(int, input().split())
    a = w
    b = d
    c = p
    g, x, y = gcd(a, b)
    if c % g != 0:
        print(-1)
        exit()
    x = c // g * x
    y = c // g * y
    xx = b // g
    yy = a // g
    if y < 0:
        t = (-y + yy - 1) // yy
        y += yy * t
        x -= xx * t
    if x < 0:
        t = (-x + xx - 1) // xx
        x += xx * t
        y -= yy * t
    if x < 0 or y < 0:
        print(-1)
        exit()
    t = y // yy
    y -= t * yy
    x += t * xx
    if x + y <= n:
        print(x, y, n - x - y)
    else:
        print(-1)
 
if __name__ == '__main__':
    main()