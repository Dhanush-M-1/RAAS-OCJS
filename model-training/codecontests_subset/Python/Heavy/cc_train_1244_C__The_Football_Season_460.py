def egcd(a,b):
    # return gcd, x,y or None
    if(a==0):
        return b,0,1
    
    gcd,x1,y1 = egcd(b%a,a)
    return gcd,y1-(b//a)*x1,x1 

n,p,w,d = list(map(int,input().strip().split()))

g,x,y = egcd(w,d)
a,b=w,d

if(p%g!=0):
    print(-1)
else:
    #find smallest sum positive solutions
    # i.e final new x and y
    factor = p//g
    x*=factor
    y*=factor

    # find minimum +ve x 
    from math import ceil
    k1=-x*g//b
    k2=y*g//a
    kmin=max(k1,k2)

    k = (n-x-y)*g//(b-a)

    flag = False
    for k in [kmin,k,-k]:
        x1 = x + k*b//g
        y1 = y - k*a//g

        z1=n-x1-y1
        if(z1>=0 and x1>=0 and y1>=0 and x1+y1+z1==n):
            print(int(x1),int(y1),int(z1))
            flag=True
            break
    if(flag==False):
        print(-1)