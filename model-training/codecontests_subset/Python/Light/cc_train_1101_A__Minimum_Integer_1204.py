n=int(input())
for i in range (n):
    z=0
    p=0
    ls=[int(i) for i in input().split()]
    x=min(ls[0],ls[1])
    y=max(ls[0],ls[1])
    if ls[2]< x:
        print (ls[2])
    else :
        q=y//ls[2]
        print (ls[2]*(q+1))
