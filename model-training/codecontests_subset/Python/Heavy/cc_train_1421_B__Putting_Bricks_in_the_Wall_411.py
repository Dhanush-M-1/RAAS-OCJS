
for i in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        ll=input()
        if i==0:
            a=int(ll[1])
        elif i==1:
            b=int(ll[0])
        if i==n-2:
            c=int(ll[n-1])
        elif i==n-1:
            d=int(ll[n-2])
    # print(a,b,c,d)
    if a!=b and c!=d:
        print(2)
        if a==1 and c==1:
            print(2,1)
            print(n-1,n)
       
        elif a==1 and c==0:
            print(2,1)
            print(n,n-1)
        
        elif a==0 and c==1:
            print(1,2)
            print(n-1,n)
            
        elif a==0 and c==0:
            print(2,1)
            print(n,n-1)
    elif a==b and c==d:
        if a==1 and c==1:
            print(2)
            print(1,2)
            print(2,1)
        elif  a==0 and c==0:
            print(2)
            print(1,2)
            print(2,1)
        else:print(0)
    
    elif a==b and c!=d:
        if a==1:
            if c==1:
                print(1)
                print(n-1,n)
            elif d==1:
                print(1)
                print(n,n-1)
        elif a==0:
            if c==0:
                print(1)
                print(n-1,n)
            elif d==0:
                print(1)
                print(n,n-1)
    elif c==d:
        if c==1:
            if a==1:
                print(1)
                print(1,2)
            elif b==1:
                print(1)
                print(2,1)
        elif c==0:
            if a==0:
                print(1)
                print(1,2)
            elif b==0:
                print(1)
                print(2,1)