def op(a,b):
    return(a[0]*b[1]- a[1]*b[0])

def vec(a,b):
    return(b[0]-a[0],b[1]- a[1])

while True:
    try:
        xa,ya,xb,yb,xc,yc,xd,yd = list(map(float,input().strip().split(',')))
        a = (xa,ya)
        b = (xb,yb)
        c = (xc,yc)
        d = (xd,yd)
        p1 = op(vec(a,b), vec(b,c))
        p2 = op(vec(b,c), vec(c,d))
        p3 = op(vec(c,d), vec(d,a))
        p4 = op(vec(d,a), vec(a,b))
        if (p1 > 0 and p2 > 0 and p3 > 0 and p4 > 0) or (p1 < 0 and p2 < 0 and p3 < 0 and p4 < 0):
            print("YES") 
        else:
            print("NO") 

    except EOFError:
        break