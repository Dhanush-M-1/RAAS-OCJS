

def gcd(a, b):
    global x, y
    if b == 0:
        x = 1
        y = 0
        return a

    if a == 0:
        x = 0
        y = 1
        return b

    g = gcd(b, a % b)
    cx = x
    cy = y
    x = cy
    y = cx - a // b * cy
    return g



def find_any_solution(a, b, c):
    global  x, y;
    g = gcd(abs(a), abs(b))
    if (c % g): return -1;
    x *= c // g
    y *= c // g
    if (a < 0) :
        x = -x;
    if (b < 0): y = -y;
    return g



def find_xmin(a, b, c):
    global x, y
    g = find_any_solution(a, b, c);
    if (g == -1): return g;
    if (x < 0):
        k = (-x + (b // g) - 1) // (b // g)
        x += b // g * k
        y -= a // g * k;
    else:

        k = - (x // (b // g))
        x += b // g * k
        y -= a // g * k;
    return g;


n, p, w, d = map(int, input().split())
g = find_xmin(d, w, p);
if (g == -1) :
        print(-1);
        quit();
assert(x >= 0);
if (y < 0) :
    print(-1);
    quit();
if (x + y > n):
    print(-1);
    quit();
assert(y * w + x * d == p);
print(str(y) + ' ' + str(x) + ' ' + str(n - x - y))