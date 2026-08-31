t=int(input())
while t:
    l=list(map(int,input().split()))
    a,b,d=l[0],l[1],l[2]
    if d<a:
        print(d)
    else:
        r=b%d
        n=d-r
        num=b+n
        print(num)
    t-=1