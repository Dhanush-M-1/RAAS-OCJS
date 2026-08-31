for i in range(int(input())):
    l,r,d=list(map(int,input().split()))
    if l<=d:
        rm=r+(d-r%d)
        print(rm)
    else:
        print(d)
    
    
    
    
    