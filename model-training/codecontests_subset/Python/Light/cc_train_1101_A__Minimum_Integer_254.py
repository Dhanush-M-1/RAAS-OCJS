for i in range(int(input())):
    l,r,d=map(int,input().split())
    if d not in range(l,r+1):
        print(d)
    else:
        print((r//d)*d+d)
        