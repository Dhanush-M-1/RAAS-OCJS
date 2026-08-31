for _ in range(int(input())):
    l,r,d = [int(_) for _ in input().strip().split()]
    if d < l:
        print(d)
    else:
        print(r+d - (r+d)%d)