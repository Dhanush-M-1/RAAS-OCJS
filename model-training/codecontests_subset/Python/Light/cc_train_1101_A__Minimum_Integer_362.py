q=int(input())
for _ in range(q):
    l,r,d=map(int,input().split())
    if(d!=1):
        if(d<l):
            print(d)
        else:
            x=d*(r//d+1)
            y=d*(l//d)
            if(y>0 and y!=l):
                print(y)
            else:
                print(x)
    elif(d==1):
        if(l>=2):
            print(1)
        else:
            print(r+1)