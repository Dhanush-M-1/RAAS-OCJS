t=int(input())
for i in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    c=0
    if(l[0]+l[1]<=max(l)):
        a=l.index(max(l))
        print(1,2,a+1)
    else:
        print(-1)