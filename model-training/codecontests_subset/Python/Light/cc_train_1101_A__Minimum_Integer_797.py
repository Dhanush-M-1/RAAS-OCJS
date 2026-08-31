t=int(input())
while t:
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    elif(d>=l):
        a=int(r/d)+1
        print(a*d)
    t-=1