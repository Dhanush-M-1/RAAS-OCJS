n=int(input())
for i in range(n):
    l,r,d=map(int,input().split())
    if not (d<=r and d>=l):
        print(d)
    else:
        p=(r-d)//d+1
        print(d+d*p)
        
        
