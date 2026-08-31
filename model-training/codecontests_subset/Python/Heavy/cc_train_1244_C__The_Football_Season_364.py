def nod(m, n):
    return m if n == 0 else nod(n, m % n)
         
n,c,a,b = map(int,input().split())
         
nodAB = nod(abs(a), abs(b))
if c % nodAB:
    print("-1")
else:
    a //= nodAB
    b //= nodAB
    c //= nodAB
         
    for k in range(abs(a)):
        if c >= b * k and ( c - b * k ) % a == 0:
            y = k
            x = ( c - b * y ) // a
            if x + y > n:
                print(-1)
            else:
                print(x,y,n - x - y)
            break
    else:
        print("-1")