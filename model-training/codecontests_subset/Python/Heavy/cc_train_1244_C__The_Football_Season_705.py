def floorDiv(a, b):
    assert b > 0
    r = 1 if abs(a)%b else 0;
    if a < 0: 
        return -(abs(a)//b + r);
    else:
        return a//b;

def ceilDiv(a, b):
    assert b > 0
    r = 1 if abs(a)%b else 0;
    if a < 0:
        return -(abs(a)//b);
    else:
        return a//b + r;

def gcd(a, b):
    if b == 0:
        return a, (1, 0)
    d, (y, x) = gcd(b, a%b)
    y -= x*(a//b)
    return d, (x, y)

n, p, w, d = map(int, input().split())

g, (x0, y0) = gcd(w, d)

assert x0*w + y0*d == g

if p%g:
    print(-1)
    exit(0)

cx = d//g
cy = w//g
s = p//g

x0 *= s
y0 *= s


low = ceilDiv(-x0, cx);
high = floorDiv(y0, cy);


# print(low, high)


if cx > cy:
    high = min(high, floorDiv(n-x0-y0, cx - cy))
elif cx < cy:
    low = max(low, ceilDiv(x0+y0-n, cy - cx))

if low > high:
    print(-1)
    exit(0)

x = x0 + low*cx
y = y0 - low*cy
z = n - x - y

assert x*w + y*d == p

print(x, y, z)