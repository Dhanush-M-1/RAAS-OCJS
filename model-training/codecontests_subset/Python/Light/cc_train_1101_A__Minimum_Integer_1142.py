q=int(input())
for i in range(q):
    l,r,d=map(int,input().split())
    if d<l:
        print(d)
    else:
        remain=d-(r+1)%d;
        if remain==d:
            print(r+1)
        else:
            print(r+1+remain)
