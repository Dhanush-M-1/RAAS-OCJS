t = int(input())
while t>0:
    l,r,d = map(int, input().split())
    x = d
    if x<l or x>r:
        print(x)
    else:
        if r%d==0:
            print(((r//d) + 1)*d)
        else:
            a = r%d
            b = ((r//d) + 1)*d
            print(b)
    t = t - 1