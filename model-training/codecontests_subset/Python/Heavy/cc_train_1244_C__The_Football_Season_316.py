#592_C2

def lcm(a, b):
    return (a * b) // math.gcd(a, b)

ln = [int(i) for i in input().split(" ")]

n = ln[0]
p = ln[1]
w = ln[2]
d = ln[3]

m = p // w
if p % w != 0:
    m += 1
f = p % w

inc = (w - d)
oinc = inc

mw = m * w
md = ((m * w) - p) % inc

x = 0

f = False
for i in range(0, inc + 1):
    if  md == 0:
        f = True
        x += 1
        break
    md = (md + (w % oinc)) % oinc
    mw += w

if f:
    x = mw // w
    y = (mw - p) // inc
    x -= y
    z = n - (x + y)
    if z < 0 or x < 0:
        print(-1)
    else:
        print(x, y, z)
else:
    print(-1)
