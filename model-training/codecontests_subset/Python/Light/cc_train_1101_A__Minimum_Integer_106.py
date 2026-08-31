for _ in range(int(input())):
    l,r,d=list(map(int,input().strip().split()))
    x=d
    if d<l:
        print(x)
        continue
    print(((r//d)+1)*d)
