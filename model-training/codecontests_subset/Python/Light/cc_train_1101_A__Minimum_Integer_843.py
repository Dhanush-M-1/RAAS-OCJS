for _ in range(int(input())):
    l,r,d = map(int,input().split())
    if d<l:
        print(d)
    else:
        m = r%d
        if r<d:
            print(d)
        else:
            x = r//d
            print(d*(x+1))