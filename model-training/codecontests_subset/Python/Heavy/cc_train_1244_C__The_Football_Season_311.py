def gcd(a,b):
    if(b%a == 0):
        return a
    if(a>b):
        a,b = b,a
    return gcd(b%a,a)

def cal(n,p,w,d):
    g = gcd(d,w)
    krn = int(d*w/g)
    for i in range(int(krn/d)+1):
        if( p - (i*d) < 0):
            break
        if((p - (i*d)) % w == 0):
            if((p - (i*d)) / w + i <= n):
                return ( (p - (i*d)) / w , i , n - ((p - (i*d)) / w) - i)
    return (0,0,0)
    

n,p,w,d = [int(i) for i in input().split()]
x,y,z = cal(n,p,w,d)
if( x+ y+z == 0):
    print(-1)
else:
    print(int(x),y,int(z))
