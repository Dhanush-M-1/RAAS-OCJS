def gcd(a, b):
    while b != 0:
        a %= b
        k = a
        a = b
        b = k
    return a

def lcm(a, b):
    return a*b/gcd(a,b)

x = int(input())
pairs = []
if x == 1:
    print ("1 1")
else:
    a = 1
    while a * a < x:
        if x % a == 0:
            b = x // a
            pairs.append((a, b))
        a += 1

    min = 9999999999999999999999999999
    mp = (0, 0)
    for p in pairs:
        if lcm(p[0], p[1]) == x:
            if p[0] + p[1] < min:
                min = p[0] + p[1]
                mp = p

    print (mp[0], mp[1])