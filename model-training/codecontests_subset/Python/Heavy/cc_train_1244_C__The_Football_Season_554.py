def ii():
    return int(input())
def mi():
    return map(int, input().split())
def li():
    return list(mi())

from math import gcd

def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        gcd, x, y = egcd(b % a, a)
        return (gcd, y - (b//a) * x, x)

def solve_Dioph(a,b,c):
    _, x, y = egcd(a, b)
    if c % g > 0:
        print(-1)
        exit()

    x *= c // g
    y *= c // g
    if (a < 0):
        x = -x;
    if (b < 0):
        y = -y;
    return x, y

n, p, w, d = mi()
a, b, c = w, d, p

g = gcd(a, b)
if p % g != 0:
    print(-1)
    exit()

x, y = solve_Dioph(a, b, p)

def get_x_y(k):
    assert((k * b) % g == 0)
    assert((k * a) % g == 0)
    ttx = x - (k * b) // g
    tty = y + (k * a) // g
    return ttx, tty

k_min = ((g * -y) + a - 1) // a
k_max = (g * x) // b
# print(k_min, k_max, get_x_y(k_min), get_x_y(k_max))
# k_max = min(k_max, ((n - (x+y)) * g) // (a-b))

if k_min > k_max:
    print(-1)
    exit()

# for wow in range(k_min - 100000, min(k_min + 100000, k_max+100000)):
x_, y_ = get_x_y(k_min)
# print(x_, y_, n - (x_ + y_))
if x_ >= 0 and y_ >= 0 and x_ + y_ <= n:
    print(x_, y_, n - (x_ + y_))
    exit()

print(-1)