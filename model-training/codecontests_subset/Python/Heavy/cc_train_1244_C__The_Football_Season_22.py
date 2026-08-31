def gcdExtended(a, b, x_param, y_param):
    # Base Case
    if a == 0:
        x_param = 0
        y_param = 1
        return b, x_param, y_param

    x1 = 1
    y1 = 1 # To store results of recursive call
    gcd, x1, y1 = gcdExtended(b % a, a, x1, y1)

    # Update x and y using results of recursive call
    x_param = y1 - (b // a) * x1
    y_param = x1

    return gcd, x_param, y_param


#from pip._vendor.distlib.compat import raw_input
#data = [int(x) for x in raw_input().split(" ")]

import sys
for line in sys.stdin:
    data = [int(x) for x in line.strip().split(' ')]
    break

n = data[0]
p = data[1]
w = data[2]
d = data[3]

x = 1
y = 1
g, x, y = gcdExtended(w, d, x, y)

if p % g:
    print("-1")
else:
    x *= (p // g)
    y *= (p // g)

    if x < 0:
        diff = -x
        win = d // g
        times = diff // win
        if diff % win: times += 1

        x += times * (d // g)
        y -= times * (w // g)

        if y < 0:
            print("-1")
            exit(0)

    if y < 0:
        diff = -y
        win = w // g
        times = diff // win
        if diff % win:
            times += 1

        x -= times * (d // g)
        y += times * (w // g)

        if x < 0:
            print("-1")
            exit(0)

    if x + y > n:
        diff = x + y - n
        win = w // g - d // g
        times = diff // win
        if diff % win:
            times += 1

        x += times * (d // g)
        y -= times * (w // g)

    if x < 0 or y < 0:
        print("-1")
    else:
        print(x, y, n - (x + y))

exit(0)