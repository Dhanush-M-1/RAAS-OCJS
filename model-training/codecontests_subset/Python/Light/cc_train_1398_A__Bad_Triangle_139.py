t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    m=l[0]+l[1]
    flag=False
    for i in range(2,n):
        if m<=l[i]:
            print(1,2,i+1)
            flag=True
            break
    if not flag:
        print(-1)
