R=lambda: map(int,input().split())
a,b,c=R()
if a==0 and b==0 and c==0:  
    print("-1")
elif (b**2)<4*a*c:    
    print("0")
elif a==0:
    if b==0:
        print("0")
    else:
        print("1")
        print("{0:.5f}".format(-(c/b)))
else:
    d= (b**2)-4*a*c
    r1= (-b+pow(d,0.5))/(2*a)
    r2= (-b-pow(d,0.5))/(2*a)
    if r1==r2:  
        print("1") 
        print("{0:.5f}".format(min(r1,r2)))
    else:
        print("2")
        print("{0:.5f}".format(min(r1,r2)))
        print("{0:.5f}".format(max(r1,r2)))