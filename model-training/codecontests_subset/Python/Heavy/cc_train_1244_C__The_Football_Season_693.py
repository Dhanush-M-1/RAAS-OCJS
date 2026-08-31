def fdiv(a, b):
    return a//b

def cdiv(a, b):
    if a % b == 0:
        return a//b
    else:
        return a//b + 1

def sol():
    n, p, w, d = map(int, input().split())
    mtx = [ [1, 0, w], [0, 1, d]]
    while mtx[1][2] != 0:
        if mtx[0][2] < mtx[1][2]:
            mxt[0], mtx[1] = mtx[1], mtx[0]
        q = mtx[0][2] // mtx[1][2]
        mtx[0][0] -= q*mtx[1][0]
        mtx[0][1] -= q*mtx[1][1]
        mtx[0][2] -= q*mtx[1][2]
        mtx[0], mtx[1] = mtx[1], mtx[0]
    g = mtx[0][2]
    h = p//g
    x = mtx[0][0] * h
    y = mtx[0][1] * h
    u = w//g
    v = d//g
    mn = -1e20
    mx = 1e20
    if v <= 0:
        mx = min(mx, fdiv(-x, v))
    else:
        mn = max(mn, cdiv(-x, v))
    if u >= 0:
        mx = min(mx, fdiv(y, u))
    else:
        mn = max(mn, cdiv(y, u))
    if v -u >= 0:
        mx = min(mx, fdiv(n-x-y, v-u))
    else:
        mn = max(mn, cdiv(n - x - y, v -u))
    if mn <= mx and p % g == 0:
        print(x + mn * v, y - mn * u, n - x - mn * v - y + mn *u)
    else:
        print(-1)

sol()
