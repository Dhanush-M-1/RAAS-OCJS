for _ in range(int(input())):
    l,r,d = tuple(map(int,input().split()))
    
    if l%d == 0:
        if l//d > 1:
            print(d)
            continue
        else:
            pass
    elif l//d > 0:
        print(d)
        continue
        
    if r%d==0:
        print( r+d )
    else:
        print( d*(r//d) + d )