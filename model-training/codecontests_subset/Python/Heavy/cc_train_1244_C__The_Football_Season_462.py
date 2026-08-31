def gcd_ext(a, b):
    if b == 0:
        return a, 1, 0
    g, x_, y_ = gcd_ext(b, a % b)
    x, y = y_, x_ - (a // b) * y_
    return g, x, y

def kill():
    print(-1)
    exit(0)

def ceil(a, b):
    if a % b:
        return a // b + 1
    return a // b

def main():
    n, p, w, d = map(int, input().split())

    g, x, y = gcd_ext(w, d)
    if p % g != 0:
        kill()

    c = p // g
    x *= c
    y *= c

    w = w // g
    d = d // g

    if x < 0:
        k = ceil(abs(x), d)
        x += k * d
        y -= k * w
    if y < 0:
        k = ceil(abs(y), w)
        x -= k * d
        y += k * w
    if x < 0:
        kill()

    k = y // w
    x += k * d
    y -= k * w

    if x + y <= n:
        print(x, y, n - x - y)
    else:
        kill()

main()
