for _  in range(int(input())):
    l,r,d=map(int,input().split())
    d1=d*1 
    if d1<l:
        print(d)
    elif d>r:
        print(d)
    else:
        l=r//d 
        print(d*(l+1))
        