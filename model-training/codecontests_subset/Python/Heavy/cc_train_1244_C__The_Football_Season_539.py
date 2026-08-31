import sys
 
def gcd(a, b):
    if b:
        return gcd(b, a % b)
    else:
        return a;

def extgcd(a, b):
    if b:
        d, y, x = extgcd(b, a % b)
        y -= (a // b) * x
        return d, x, y
    else:
        return a, 1, 0
 
n, p, w, d = map(int, input().split())
tmp = extgcd(w, d)
 
t = w * tmp[1] + d * tmp[2];
if p % t != 0:
    print(-1)
    sys.exit()
 
x = tmp[1] * (p // t)
y = tmp[2] * (p // t)

g = gcd(w, d)
w //= g
d //= g

if x < 0:
    plus = -x
    cnt = (plus + d - 1) // d
    x += cnt * d
    y -= cnt * w
elif y < 0:
    plus = -y
    cnt = (plus + w - 1) // w
    x -= cnt * d
    y += cnt * w

if x < 0 or y < 0:
    print(-1)
    sys.exit()
 
cnt = y // w
x += cnt * d
y -= cnt * w

if x + y > n:
    print(-1)
    sys.exit()
 
print(x, y, n - x - y)