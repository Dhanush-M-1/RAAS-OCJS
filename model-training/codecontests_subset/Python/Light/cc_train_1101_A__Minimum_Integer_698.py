for _ in range(int(input())):
    l,r,c=[*map(int,input().split())]
    count=c
    if c<l:
        print(c)
    elif c>r:
        print(c)
    else:
        print(c*((r//c)+1))