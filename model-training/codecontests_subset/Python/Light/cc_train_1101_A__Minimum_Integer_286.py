t=int(input())
for i in range(t):
    l,r,d=map(int,input().split())
    if d<l or d>r:
        print(d)
    else:
        if (r%d==0):
            print(r+d)
        else:
            x=(r//d)*d+d
            print(x)
        