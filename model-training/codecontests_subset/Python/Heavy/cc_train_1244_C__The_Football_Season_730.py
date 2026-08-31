
def exgcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, x, y = exgcd(b % a, a)
        return (g, y - (b // a) * x, x)

if __name__ == "__main__":
    n, p, w, d = map(int, input().split())
    r, x, y = exgcd(w, d)
    if p % r:
        print(-1)
    else:
        x = p // r * x
        y = p // r * y
        d = d // r
        w = w // r
        y0 = ((y % w) + w) % w
        x0 = (p // r - y0 * d) // w
        if x0 >= 0 and y0 >= 0 and x0 + y0 <= n:
            print("%d %d %d" % (x0, y0, n - x0 - y0))
        else:
            print(-1)
 
