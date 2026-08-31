b=int(input())
for _ in range (b):
    a=int(input())
    c=list(map(int,input().split()))
    c.sort()
    q=0
    if c[0]+c[1]<=c[a-1]:
        print (1,2,a)
    else :
        print(-1)


