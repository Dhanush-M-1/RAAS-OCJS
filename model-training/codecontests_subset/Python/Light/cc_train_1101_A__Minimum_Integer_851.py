q=int(input())
for i in range(0,q):
    l,r,d=map(int,input().split())
    if l<=d<=r:
        a=r//d
        print((a+1)*d)
    else:
        print(d)
            
