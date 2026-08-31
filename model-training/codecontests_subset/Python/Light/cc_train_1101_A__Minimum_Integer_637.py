for _ in range(int(input())):
    l,r,d = map(int,input().split())
    t = l//d
    if t>1:
        print(d)
    elif t==1 and l>d:
        print(d)
    else:
        if d>r:
            print(d)
            continue
        t = r//d
        
        print((t+1)*d)