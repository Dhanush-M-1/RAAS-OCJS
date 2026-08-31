for i in range(int(input())):
    l,r,d = map(int,input().split())
    if d < l:
        print(d)
    else:
        if (r+1) % d == 0:
            print(r+1)
        else:
            print(r+1+d-(r+1)%d)
                
