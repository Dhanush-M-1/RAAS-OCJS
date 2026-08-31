for i in range(int(input())):
    l,r,d=map(int,input().split(" "))
    if l-d>0:
        print(d)
    elif r<d:
        print(d)
    elif d>=l and d<=r:
        m=int(r/d)+1
        print(d*m)