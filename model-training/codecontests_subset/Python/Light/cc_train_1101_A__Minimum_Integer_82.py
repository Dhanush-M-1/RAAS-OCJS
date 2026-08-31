for _  in range(int(input())):
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
        continue
    else:
        x=(r+1)%d
        if(x==0):
            d=0
        print(r+1+(d-x))
