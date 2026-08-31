#abc
for _ in range(int(input())):
    n = int(input())
    lis=[]
    for i in range(n):
        a,b = map(int,input().split())
        lis.append([a,b])
        c=1
    if lis[0][0]>=lis[0][1]:
        for i in range(1,n):
            a=lis[i][0]-lis[i-1][0]
            b=lis[i][1]-lis[i-1][1]
            if lis[i][0]>=lis[i][1] and lis[i-1][0]<=lis[i][0] and lis[i-1][1]<=lis[i][1] and a>=b:
                continue
            else:
                c=0
                break
    else:
        c=0
    if c:
        print("YES")
    else:
        print("NO")        
