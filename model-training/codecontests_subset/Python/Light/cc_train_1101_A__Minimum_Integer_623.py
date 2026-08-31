for _ in range(int(input())):
    l,r,d = map(int, input().split())
    if l//d >= 1:
        if l//d != l/d:
            print(d)
        elif l//d == l/d and d<l:
            print(d)
        else:
            print(d*(r//d + 1))
    else:
        print(d*(r//d + 1))