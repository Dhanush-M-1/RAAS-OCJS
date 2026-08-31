n,p,w,d = (int(i) for i in input().split())

def gcd(a,b):
    x, xx, y, yy = 1, 0, 0, 1
    while b:
        q = a // b
        a, b = b, a % b
        x, xx = xx, x - xx*q
        y, yy = yy, y - yy*q
    return (x, y, a)


def find_any_solution(a,b,c):
    g = gcd(abs(a),abs(b))
    x0,y0=g[0],g[1]
    if c%g[2] != 0:
        return (0,0,0)
    x0 *= c//g[2]
    y0 *= c//g[2]
    if a<0: x0*=-1
    if b<0: y0*=-1
    return (x0,y0,g[2])

x,y,g = find_any_solution(w,d,p)
if x==y==g==0:
    print(-1)
else:
    lx = x + -(x*g//d)*d//g
    k = -(-(n-x-y)*g//(d-w))
    x+=k*d//g
    y-=k*w//g
    if p == 0:
        print(0,0,n)
    else:
        if x>=0 and y>=0:
            print(x,y, n-x-y)
        else:
            x = lx
            y = (p-w*x)//d
            k = (y-n)*g//w
            if x+y<=n and 0<=x<=n and 0<=y<=n:
                print(x,y,n-x-y)
            else:
                x+=k*d//g
                y-=k*w//g
                k=1
                while x+y>n and x<n and y>=0:
                    x+=k*d//g
                    y-=k*w//g
                    k+=1
                if x+y<=n and 0<=x<=n and 0<=y<=n:
                    print(x,y,n-x-y)
                else:
                    print(-1)