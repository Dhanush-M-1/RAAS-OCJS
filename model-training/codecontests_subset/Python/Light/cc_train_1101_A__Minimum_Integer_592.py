t=int(input())
for z in range(t):
    l,r,d=map(int,input().split())
    if(d<l or d>r):
        print(d)
    else:
        x=r%d
##        print(x)
        sid=r-x+d
        print(sid)