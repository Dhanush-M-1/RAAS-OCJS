q=int(input())
while q>0:
    l,r,d=map(int,input().split())
    a=l/d
    b=r/d
    min=0
    if a>1:
        min=d
    else:
        min=(int(b)+1)*d
    print(min)
    q-=1
