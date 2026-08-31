import math

n, p, w, d = [int(x) for x in input().split()]
g = math.gcd(w, d)
poss = 1
u = 0
v = 0
for i in range (1, d+1):
    if ((w*i - g) % d == 0):
        u = i
        v = ((w*i - g)//d)
        break

if (p%g != 0):
    poss = 0

x = u * (p//g)
y = v * (p//g)
mx = x//(d//g)
mr = y//(w//g) + int(bool(y%(w//g)))
mx = min(mx, (n-x+y)//((w-d)//g))

if (mr > mx):
    poss = 0

if (poss == 1):
    wn = x - (d//g)*mr
    dr = -y + (w//g)*mr
    ls = n - wn - dr
    print(wn, end = " ")
    print(dr, end = " ")
    print(ls)
else:
    print(-1)
