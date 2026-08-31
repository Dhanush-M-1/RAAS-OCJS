a1,a2,a3=input("").split()
a= int(a1)
b = int(a2)
c= int(a3)
d =b*b - (4*a*c)
if a==0 and b==0 and c==0:
    print("-1")
elif d < 0 or d>0 or d==0:
    if d>0 and a!=0:
        r1 = (-b+(d**0.5))/(2*a)
        r2 = (-b-(d**0.5))/(2*a)
        mi = min(r1,r2)
        ma = max(r1,r2)
        print("2")
        print(("{0:.10f}".format(mi)))
        print(("{0:.10f}".format(ma)))
    if d<0:
        print("0")
        
    if d==0 and a!=0:
        r1 = (-b+(d**0.5))/(2*a)
        print("1")
        print(("{0:.10f}".format(r1)))
    if a==0 and b!=0:
        r1 = -c/b
        print("1")
        print(("{0:.10f}".format(r1)))
    if a==0 and b==0:
        print("0")