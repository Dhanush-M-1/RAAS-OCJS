for _ in range(int(input())):
    n=int(input())
    l=[list(map(int,input().split())) for i in range(n)]
    f=0
    if l[0][0]<l[0][1]:
        print("NO")
    else:

        for i in range(1,n):
            if l[i][0]>=l[i][1] and l[i][0]==l[i-1][0] and l[i][1]==l[i-1][1]:
                continue
            elif l[i][0]>=l[i][1] and l[i][0]>l[i-1][0] and l[i][1]>=l[i-1][1] and l[i][0]-l[i-1][0]>=l[i][1]-l[i-1][1]:
                continue
            else:
                f=1
                break
        if f:
            print("NO")
        else:
            print("YES")