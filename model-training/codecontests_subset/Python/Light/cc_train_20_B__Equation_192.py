a,b,c=map(int,input().split())
if a==0:
    if b==0:
        if c==0:
            print(-1)
        else:
            print(0)
    else:
        print("1\n"+str(-c/b))
else:
    if b*b==4*a*c:
        print(1)
        print("{0:.10f}".format(-b/(2*a)))
    elif b*b<4*a*c:
        print(0)
    else:
        print(2)
        d=(b*b-4.0*a*c)**0.5
        print("{0:.10f}\n{1:.10f}".format(*sorted([(-b-d)/(2*a),(-b+d)/(2*a)])))

