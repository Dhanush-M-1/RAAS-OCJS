def egcd(a, b):
    """return (g, x, y) such that a*x + b*y = g = gcd(a, b)"""
    if a == 0:
        return (b, 0, 1)
    else:
        b_div_a, b_mod_a = divmod(b, a)
        g, x, y = egcd(b_mod_a, a)
        return (g, y - b_div_a * x, x)

X = 1; Y = 1; GCD = 1; 
n, p, w, d = map(int, input().split())
__ = egcd(w, d)
X = __[1]
Y = __[2]
GCD = __[0]

if p % GCD != 0:
    print(-1)
else:
    X *= p // GCD;
    Y *= p // GCD;
    LCM = w * d // GCD;
    a = LCM // w;
    b = LCM // d;
    if X > Y:
        alp = (-Y + b - 1) // b;
        x = X - alp * a;
        y = alp * b + Y;
        z = n - x - y;
        if x < 0 or y < 0 or z < 0:
            print(-1)
        else:
            print(x, end = " ")
            print(y, end = " ")
            print(z)
    else:
        alp = Y // b;
        x = alp * a + X;
        y = Y - alp * b;
        z = n - x - y;
        if x < 0 or y < 0 or z < 0:
            print(-1)
        else:
            print(x, end = " ")
            print(y, end = " ")
            print(z)
    
    
    
    
    
    
    