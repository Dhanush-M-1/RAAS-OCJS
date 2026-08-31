q=int(input())
for x in range(q):
    l,r,d=list(map(int,input().split()))
    a=l/d
    b=r/d
    if a>1:
        print(d)
    else:
        print((int(b)+1)*d)
        
        
        
        