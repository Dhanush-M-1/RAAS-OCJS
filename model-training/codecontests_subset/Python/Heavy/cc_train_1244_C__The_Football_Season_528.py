from math import *
def solve_Dioph(w,d,p):
    gcd_1 = gcd(w, d)

    w = w//gcd_1
    d = d//gcd_1
    p = p//gcd_1

    m1=1
    m2=0
    n1=0
    n2=1
    r1=w
    r2=d

    while r1%r2!=0:
        q=r1//r2
        aux=r1%r2
        r1=r2
        r2=aux
        aux3=n1-(n2*q)
        aux2=m1-(m2*q)
        m1=m2
        n1=n2
        m2=aux2
        n2=aux3
    return m2*p,n2*p;

inp = input()
inp_arr = inp.split(" ")
n = int(inp_arr[0])
p = int(inp_arr[1])
w = int(inp_arr[2])
d = int(inp_arr[3])
gcd_val = gcd(w, d)
if p%gcd_val != 0:
    #print("IN")
    print(-1)
else:
    (x_0, y_0) = solve_Dioph(w,d,p)

    #print(x_0,y_0)
    d = d//gcd_val
    w = w//gcd_val
    p = p//gcd_val
    if abs(x_0)%d ==0:
        lower = -(x_0//d)
    else:
        lower = floor(-x_0//d) +1
    if abs(y_0)%w ==0:
        upper = y_0//w
    else:
        upper = floor(y_0//w)

    if abs((x_0+y_0)-n)%(w-d) ==0:
        lower1 = ((x_0+y_0)-n)//(w-d)
    else:
        lower1 = floor((x_0+y_0)-n)//(w-d)+1

    if max(lower1, lower)>upper:
        #print(lower1, lower, upper)
        #print("IN")
        print(-1)
    else:
        x = (x_0 + upper*d)
        y = (y_0- upper*w)
        print(str(x), str(y), str(n-x-y))