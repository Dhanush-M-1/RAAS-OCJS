from math import atan, pi
E = 10**-10

def cross(a0,a1,b0,b1):
    return a0*b1-a1*b0

while(1):
    a = [0 for i in range(2)]
    b = [0 for i in range(2)]
    c = [0 for i in range(2)]
    d = [0 for i in range(2)]
    try:
        a[0],a[1],b[0],b[1],c[0],c[1],d[0],d[1] = [float(i) for i in input().split(",")]
        A = cross((d[1]-a[1]),(d[0]-a[0]),(b[1]-a[1]),(b[0]-a[0]))
        B = cross((c[1]-d[1]),(c[0]-d[0]),(a[1]-d[1]),(a[0]-d[0]))
        C = cross((b[1]-c[1]),(b[0]-c[0]),(d[1]-c[1]),(d[0]-c[0]))
        D = cross((a[1]-b[1]),(a[0]-b[0]),(c[1]-b[1]),(c[0]-b[0]))
        if A*B*C*D < 0:
            print("NO")
        else:
            print("YES")
    except EOFError:
        break
