t=int(input())
while t:
    n=int(input())
    x=10000000000000
    count=0
    if n==1:
        print("0")
    else:
        f=0
        while n!=1 and n<=x:
            if n%6==0:
                count+=1
                n=n//6
                f=1
                #print(" n/6 = ",n)
            else:
                n=n*2
                count+=1
                f=0
                #print(" nX2 = ",n)
        if f==1:
            print(count)
        else:
            print("-1")
                                
        
    t=t-1
