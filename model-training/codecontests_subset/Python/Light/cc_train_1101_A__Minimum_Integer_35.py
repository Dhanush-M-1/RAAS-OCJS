for _ in range(int(input())):
    l,r,d = map(int,input().split())
    if l>d or r<d:
        print(d)
    else:
        t = r//d
        print((t+1)*d)