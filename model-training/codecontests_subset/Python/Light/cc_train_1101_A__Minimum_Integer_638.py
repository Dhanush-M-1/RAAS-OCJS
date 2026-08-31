for _ in range(int(input())):
    l,r,d=map(int,input().split())
    x=y=0
    if l>d:
        x=d
        print(x)
    else:
        if r%d==0:
            y=r+d
            #print('Hello',y)
        else:
            y=((r)//d)*d
            #print(y)
            y+=d
        print(y)
    
        
