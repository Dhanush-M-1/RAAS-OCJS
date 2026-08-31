

def factorize(x):
    res = []
    i = 2
    while i <= 5:
        while x % i == 0:
            res.append(i)
            x /= i
        i += 1
    res.append(int(x))
    return res[::-1]

def countVal(fr, x):
    for i in fr:
        if i == 2:
            x[0] += 1
        elif i == 3:
            x[1] += 1
        elif i == 5:
            x[2] += 1


a, b = map(int, input().split())
a1 = factorize(a)
b1 = factorize(b)
xa = [0, 0, 0]
xb = [0, 0, 0]
if a1[0] != b1[0]:
    print(-1)
else:
    countVal(a1, xa)
    countVal(b1, xb)
    print(abs(xa[0]-xb[0]) + abs(xa[1]-xb[1]) + abs(xa[2]-xb[2]))
