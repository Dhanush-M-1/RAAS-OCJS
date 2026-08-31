t=int(input())
if 1<=t<=100:
    for i in range(t):
        a,b,c=input().split()
        a=int(a)
        b=int(b)
        c=int(c)
        if c>=2*b:
            k=3*b
            if k>=3:
                print(k)
            else:
                print(0)
        else:
            k=(c//2)*3
            j=b-k/3
            if j>=2*a:
                l=3*a
                z=k+l
                z=int(z)
                if z>=3:
                    print(z) 
                else:
                    print(0)             
            else:
                l=(j//2)*3
                z=k+l
                z=int(z)
                if z>=3:
                    print(z)
                else:
                    print(0)
