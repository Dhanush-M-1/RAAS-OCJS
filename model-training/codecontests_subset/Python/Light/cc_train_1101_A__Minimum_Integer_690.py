for _ in range(int(input())):
    l,r,d = [int(i) for i in input().split()]
    if d < l:
        print(d)

    else:
        if r%d == 0:
            print(r+d)
        else:
            print((r//d + 1) * d)