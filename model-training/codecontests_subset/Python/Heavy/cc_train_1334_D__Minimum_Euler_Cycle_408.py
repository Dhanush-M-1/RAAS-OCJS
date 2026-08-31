from bisect import bisect_left

def get(x, n):
    if x==n: return [1]
    return [a for i in range(x+1,n+1) for a in [x,i]]

def solve():
    n,l,r = map(int,input().split())
    cum = [0]*(n+1)
    for i in range(1,n):
        cum[i] = cum[i-1] + 2*(n-i)
    cum[n] = cum[n-1] + 1
    xL = bisect_left(cum, l)
    xR = bisect_left(cum, r)
    hL = l - cum[xL-1] - 1
    hR = r - cum[xR-1] - 1
    if xL==xR:
        u = get(xL, n)
        print(*u[hL:hR+1])
        return
    uL, uR = get(xL, n), get(xR, n)
    print(*uL[hL:], end=" ")
    for x in range(xL+1, xR):
        print(*get(x, n), end=" ")
    print(*uR[:hR+1])
    return

for _ in range(int(input())):
    solve()
