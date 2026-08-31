for u in range(int(input())):
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    elif(d>=l and d<=r):
        print((r//d+1)*d)
    elif(d>r):
        print(d)