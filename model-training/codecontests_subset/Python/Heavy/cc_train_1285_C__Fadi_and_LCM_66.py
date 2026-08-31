import math
n=int(input())
if n==1:
    print('1 1')
elif n==2:
    print('1 2')
elif n==3:
    print('1 3')
elif n==4:
    print('1 4')
elif n==5:
    print('1 5')
else:
    m=n+1
    t1=0
    t2=0
    for j in range(1,math.ceil(math.sqrt(n))+1):
        if n%j==0:
            n1=n//j
            
            if max(j,n1)<m:
                if math.gcd(j,n1)==1:
                    m=max(n,n1)
                    t1=j
                    t2=n1
    print(t1,t2,end=" ")
                    
        