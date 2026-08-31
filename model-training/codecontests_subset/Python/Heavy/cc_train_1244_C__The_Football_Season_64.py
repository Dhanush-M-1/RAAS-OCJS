import sys
input = sys.stdin.readline
 
n, p, w, d = map(int, input().split())
 
cw0 = p // w
cd0 = (p-cw0*w) // d
p0 = p - cw0 * w - cd0 * d
 
##print(cw0, p0)
 
bad = False
if p0 == 0:
    x = cw0
    y = cd0
else:
    bad = True
    for k in range(1, min(d, cw0)+1):
##        if k > 99990:
##            print(k, w*k, (w*k)%d, p0)
        if (w*k+p0)%d == 0:
            bad = False
            x = max(0, cw0 - k)
            y = (p - x*w) // d
##            print(x, y)
            break
 
if bad or x+y > n:
    print(-1)
else:
    print(x, y, n-x-y)
