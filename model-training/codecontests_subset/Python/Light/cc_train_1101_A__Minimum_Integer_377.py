for x1 in range(int(input())):
    l,r,d=map(int,input().split())
    if d<l or d>r:
        print(d)
    else:
        print((int(r/d)+1)*d)
