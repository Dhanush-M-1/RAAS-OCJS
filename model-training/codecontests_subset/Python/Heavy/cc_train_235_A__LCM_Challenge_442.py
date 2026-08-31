def gcd(x,y):
    if(y==0):
        return x
    return gcd(y,x%y)


n=int(input())

if(n==1):
    print(1)
elif(n==2):
    print(2)
elif(n%2):
    print((n*(n-1)*(n-2)))
else:
    max1=(n-1)*(n-2)*(n-3)
    for i in range(n-1,max(n-50,1),-1):
        gcd1=gcd(n,i)   
        lcm1=int(n*i/gcd1)
        for j in range(n,max(n-50,0),-1):
            gcd2=gcd(lcm1,j)
            if(max1<(lcm1*j)//gcd2):
                pass
                #print(n,i,j,gcd1,gcd2,lcm1,lcm1*j)
            max1=max(max1,(lcm1*j)//gcd2)
    print(int(max1))
                
    