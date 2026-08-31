q=int(input())
while q>0:
    l,r,d=input().split(" ")
    l=int(l)
    r=int(r)
    d=int(d)

    if d<l:
        print(d)
    else:
        print((int(r/d)+1)*d)
    q-=1