q=int(input())
while(q>0):
    l,r,d=[int(x) for x in input().split()]
    if (d>l and d>r) or (d<l and d<r):
        print(d)
    else:
        if r%d==0:
            print(r+d)
        else:
            print(r//d*d+d)
    q-=1