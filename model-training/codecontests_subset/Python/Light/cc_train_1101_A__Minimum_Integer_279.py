for _ in range(int(input())):
    l,r,d = map(int,input().split())
    if l<=d:
        print((d-(r%d))+r)
    else:
        print(d)