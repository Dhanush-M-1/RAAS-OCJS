tt=int(input())
while tt:
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    elif(d>r):
        print(d)
    else:
        print(int((r//d+1)*d))
    tt-=1
