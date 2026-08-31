t=int(input())
while(t>0):
    t=t-1
    l,r,d=map(int,input().split())
    if(l>d):
        print(d)
    else:
        print(((r//d)+1)*d)
