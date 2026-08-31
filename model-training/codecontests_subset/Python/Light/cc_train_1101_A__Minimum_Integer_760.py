for C in range(int(input())):
    a,b,c = map(int,input().split())
    # a = max(a,b)
    d = c*(b//c)
    if c < a:
        print(c)
        continue
    else:
        while d <= b:
            d+=c
        print(d)