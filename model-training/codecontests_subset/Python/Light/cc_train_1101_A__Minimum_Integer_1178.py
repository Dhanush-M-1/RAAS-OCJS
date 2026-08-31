t=int(input())
while(t):
    t-=1;
    l,r,d=map(int,input().split());
    if(l>d):
        print(d);
    else:
        a= ((r+(d-1))//d)*d ;
        if(a==r):
            print(a+d);
        else:
            print(a);