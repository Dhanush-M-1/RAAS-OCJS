t = int(input())
for i in range(t):
    n = int(input())
    l = list(map(int,input().split()))
    ans = []
    flag = 0
    for j in range(2,n):
        if(l[0]+l[1]<=l[j]):
            flag = 1
            ans = [1,2,j+1]
            break
    if(flag==1):
        print(*ans)
    else:
        print(-1)
