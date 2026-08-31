t=int(input())
while t!=0:
    t-=1
    n=int(input())
    l=list(map(int,input().split()))
    fl=1
    if l[0]+l[1]<=l[-1]:
        print("1 2",n)
    else:
        print("-1")
    
    
        