q=int(input())
for i in range(1,q+1):
    
    l,r,d=map(int,input().split())
    if((d>=l) and (d<=r)):
        x=d*((r//d)+1)     
    elif(d>r):
        x=d
    elif(d<l):
        x=d
    print(x)    