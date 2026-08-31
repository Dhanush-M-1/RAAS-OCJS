import math
def check(b):
    for i in range(2,int(math.sqrt(b))+1):
        if b%i==0:
            return 0
    return 1

def gcd(p,q):
    if q==0:
        return p
    return gcd(q,p%q)

n=int(input())

if n<=2:
    print (n)
else:
    a=n*(n-1)
    ans1=(a*(n-2))//gcd(a,n-2)

    b=n*(n-1)
    ans2=0
    

    for i in range(n-2,max(0,n-52),-1):
        if gcd(b,i)==1:
            ans2=(b*(i))//gcd(b,i)
            # print (i)
            break
    
    c= (max(ans1,ans2))

    if n%2==0:
        a=(n-1)*(n-2)
        temp=(a*(n-3))//gcd(a,n-3)

        c=max(c,temp)

    print (c)
