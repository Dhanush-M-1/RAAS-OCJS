n=int(input())
for i in range(n):
    l,r,d=map(int,input().split())
    if d==1 and l==1:
        print(r+1)
    elif d==1 and l!=1:
        print(1)
    elif d!=1 and d>=l and d<=r:
        
        t=r//d
        print(d*(t+1))
    elif d!=1 and d>r:
        print(d)
    elif d!=1 and d<l:
        print(d)