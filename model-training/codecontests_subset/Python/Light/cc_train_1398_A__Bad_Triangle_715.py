t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    f=0
    for i in range(2,n):
        if l[0]+l[1]<=l[i]:
            f=1
            print(1,2,i+1)
            break
    if f==0:
        print(-1)