import math
 
def gcd(a, b, x, y):
    if a == 0:
        return (b, 0, 1)
    (d, x1, y1) = gcd(b % a, a, x, y)
    x = y1 - (b // a) * x1
    y = x1
    return (d, x, y)
 
def find_any_solution(a, b, c, x0, y0, g):
    (g, x, y) = gcd(abs(a), abs(b), x0, y0)
    if c % g != 0:
        return (False, 0, x, y)
    x *= c // g
    y *= c // g
    if a < 0:
        x = -x
    if b < 0:
        y = -y
    return (True, g, x, y)
 
n, p, w, d = map(int, input().split())
(has, g, x0, y0) = find_any_solution(w, d, p, 0, 0, 0)
if has == False:
    print(-1)
else:
    #print(((-x0) * g / d), g * (x0 + y0 - n) / (w - d))
    #print(math.ceil((-x0) * g / d), math.ceil(g * (x0 + y0 - n) / (w - d)))
    mn = max(math.ceil((-x0) * g / d), math.ceil(g * (x0 + y0 - n) / (w - d)))
    if mn > (y0 * g // w):
        print(-1)
    else:
        k = mn
        x = x0 + k * (d // g)
        y = y0 - k * (w // g)
        if n - x - y < 0:
            k = mn + 1
            x = x0 + k * (d // g)
            y = y0 - k * (w // g)
        #x2 = x0 + (k + 1) * (d // g)
        #y2 = y0 - (k + 1) * (w // g)
        print(x, y, n - x - y)
        #print(x2, y2, n - x2 - y2)