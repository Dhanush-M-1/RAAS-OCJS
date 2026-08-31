def IO():
    import sys
    sys.stdout = open('output.txt', 'w')
    sys.stdin = open('input.txt', 'r')

def extendedGcd(a, b):
    if (b == 0): return 1, 0
    _x, _y = extendedGcd(b, a % b)
    result = _y, _x - _y * (a // b)
    return result

def gcd(a, b):
    if (b == 0): return a
    return gcd(b, a % b)

###################### MAIN PROGRAM #####################
def main():
   # IO()
    n, p, w, d = map(int, input().split())
    s, t = extendedGcd(w, d)
    g = gcd(w, d)

    if (p % g != 0):
        print(-1)
        exit(0)

    x0, y0 = s * p // g, t * p // g

    k = y0 * g // w
    x = x0 + k * d // g
    y = y0 - k * w // g

    if (y < 0 or x < 0):
        print(-1)
        exit(0)
    if x + y > n : 
        print(-1)
        exit(0)
    assert x * w + y * d == p
    print(f"{x} {y} {n - x - y}")

##################### END OF PROGRAM ####################
if __name__ == "__main__":
    main()