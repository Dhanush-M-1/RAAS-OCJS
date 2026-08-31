for i in range(int(input())):
    l,r,d = map(int,input().split())
    if l > d:
        print(d)
    else:
        n = r % d
        print(r + d - n)
