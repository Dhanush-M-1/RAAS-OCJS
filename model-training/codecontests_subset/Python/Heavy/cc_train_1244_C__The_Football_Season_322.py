def egcd(a, b):
    x,y, u,v = 0,1, 1,0
    while a != 0:
        q, r = b//a, b%a
        m, n = x-u*q, y-v*q
        b,a, x,y, u,v = a,r, u,v, m,n
    gcd = b
    return gcd, x, y

def modinv(a, m):
    gcd, x, y = egcd(a, m)
    if gcd != 1:
        return None  
    else:
        return x % m

def gcd(n1,n2):
    if n2 > n1:
        return gcd(n2,n1)
    if n2 == 0:
        return n1
    return gcd(n2,n1%n2)

def main():
    n,p,w,d = map(int,input().split())
    g = gcd(p,d)
    g = gcd(g,w)
    p = p//g
    d = d//g
    w = w//g
    din = modinv(d,w)
    if not din:
        print(-1)
        return
    y = (p*din)%w
    x = (p-(y*d))//w
    z = n-x-y

    if x >= 0 and y >= 0 and z >= 0:
        print(x,y,z)
    else:
        print(-1)


main()
