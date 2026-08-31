for i in range(int(input())):
    l,r,d=map(int,input().split())
    x=l%d
    y=r%d
    if l>d:
        print(d)
    else :
        print(r+(d-y))