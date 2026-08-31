def gcd(a, b):
    x = 0
    y = 1
    if (a == 0):
        return (b, x, y)
 
    d, x1, y1 = gcd(b % a, a)
 
    x = y1 - (b // a) * x1;
    y = x1
    return (d, x, y)
 
 
n, c, b, a = map(int, input().split())
 
nod, x1, y1 = gcd(a, b)
if (c % nod != 0):
    print(-1)
else:
    a //= nod
    b //= nod
    c //= nod
    x1 *= c
    y1 *= c
    rt = x1
    rt += 1000000000000000000 * b
    rt %= b
    x1 = rt
    y1 = (c * nod - x1 * nod * a) // (nod * b)
    if (y1 < 0):
        print(-1)
    elif (x1 + y1 > n):
        print(-1)
    else:
        ans1 = y1
        ans2 = x1
        ans3 = n - x1 - y1
        print(ans1, ans2, ans3)