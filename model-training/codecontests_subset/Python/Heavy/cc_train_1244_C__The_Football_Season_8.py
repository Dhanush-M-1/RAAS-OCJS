x=0
y=0
g=0
def extendedEuclid(a,b):
    global x
    global y
    global g
    if (b == 0):
        x = 1
        y = 0
        g = a
        return
    extendedEuclid(b, a % b)
    CX = y
    CY = x - (a // b) * y
    x = CX
    y = CY

n,p,w,d=map(int,input().split())
extendedEuclid(w, d)
#print(" ",x," ",y)
if (p % g != 0):
    print("-1")
else:
    x = x * p // g
    y = y * p // g
    k = p // g
    #print(x,y)
    lower1 = int((-1) * x * g / d)
    if(lower1 > 0):
        lower1+=1
    lower2 = int(g * (x + y - n) /(w - d))
    if(lower2 > 0):
        lower2+=1
    upper = (g * abs(y)) // w
    if(y<0):
        upper=upper*(-1)
    if (upper < 0):
        upper-=1
    lower = max(lower1, lower2)
    #print("a ",lower1," ",lower2," ",upper)
    if(lower > upper):
        t=lower
        x = x + ((d * t) // g)
        y = y - ((w * t) // g)
        z = n - x - y
        if(x>=0 and y>=0 and z>=0):
            print(x,y,z)
        else:
            print("-1")
    else:
        t=lower
        f1 = x + ((d * t) // g)
        f2= y - ((w * t) // g)
        f3= n - f1 - f2
        if(f1>=0 and f2>=0 and f3>=0):
            print(f1," ",f2," ",f3)
        elif(upper>lower):
            t=lower+1
            x = x + ((d * t) // g)
            y = y - ((w * t) // g)
            z = n - x - y
            if(x>=0 and y>=0 and z>=0):
                print(x," ",y," ",z)
            else:
                print("-1")
        else:
            print("-1")
        #print(y)
        #print(z)