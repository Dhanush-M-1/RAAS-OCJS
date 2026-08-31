t=int(input())
while(t>0):
    t-=1
    l,r,d=map(int,input().split())
    if(l%d==0):
        if(l//d==1):
            print((r//d+1)*d)
        else:
            print(d)
    else:
        if(l>d):
            print(d)
        else:
            print((r//d+1)*d)
    
