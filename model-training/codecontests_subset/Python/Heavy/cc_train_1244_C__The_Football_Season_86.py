import sys
x = 0
y = 0
def exgcd(a,b):
    global x,y
    if b == 0:
        x = 1
        y = 0
        return a
    ret = exgcd(b,a % b)
    t = x
    x = y
    y = t - (a // b) * y
    return ret

n,p,w,d = map(int,input().split())
ret = exgcd(w,d)
if p % ret:
    print(-1)
else:
    x *= p // ret
    y *= p // ret
    d //= ret
    w //= ret
    # print(x,y)
    if x < 0:
        tmp = (-x + d - 1) // d
        x += tmp * d
        y -= tmp * w
    elif y < 0:
        tmp = (-y + w - 1) // w
        x -= tmp * d
        y += tmp * w
    if x >= 0 and y >= 0:
        if w > d:
            tmp = y // w
            y %= w
            x += tmp * d
        else:
            tmp = x // d
            x %= d
            y += tmp * w
    if x + y > n or x < 0 or y < 0:
        print(-1)
    else:
        print(x,y,n - x - y)