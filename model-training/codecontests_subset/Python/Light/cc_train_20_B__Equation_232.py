a,b,c=map(int,input().split())
if a==0:
    if b==0:
        if c==0:
            print("-1")
        else:
            print("0")
    else:
        print(1)
        print("%.6f"%((-c)/b))
else:
    d=b*b-4*a*c
    if d<0:
        print(0)
    elif d==0:
        print(1)
        print("%.6f"%((-b)/(2*a)))
    else:
        print(2)
        l=[((-b-(d**0.5))/(2*a)),((-b+(d**0.5))/(2*a))]
        l.sort()
        print("%.6f"%l[0])
        print("%.6f"%l[1])