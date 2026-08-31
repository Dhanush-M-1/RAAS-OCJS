# cook your dish here
t=int(input())
while t>0 :
    n=int(input())
    for i in range(n) :
        l=input()
        if i==0 :
            a=l[1]
        if i==1 :
            b=l[0]
        if i==n-2 :
            c=l[-1]
        if i==n-1 :
            d=l[-2]
    if a==b and c==d :
        if a!=c :
            print(0)
        else :
            print(2)
            print(1,2)
            print(2,1)
    else :
        if a==b :
            print(1)
            if c!=a :
                print(n,n-1)
            else :
                print(n-1,n)
        elif c==d :
            print(1)
            if a!=c :
                print(2,1)
            else :
                print(1,2)
        else :
            print(2)
            if a=='1' :
                print(2,1)
            else :
                print(1,2)
            if c=='0' :
                print(n,n-1)
            else :
                print(n-1,n)
    t-=1
