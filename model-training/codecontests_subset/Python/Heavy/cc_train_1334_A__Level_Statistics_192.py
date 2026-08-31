for _ in range(int(input())):
    l = []
    n = int(input())
    for i in range(n):
        a = list(map(int,input().split()))
        l.append(a)
    f=0
    if n==1:
        if l[0][0]<l[0][1]:
            f=1
    else:
        for i in range(1,n):
            if l[i][1]<l[i-1][1] or l[i][0]<l[i][1]:
                f=1
                break
            elif l[i][0]>=l[i-1][0]:
                if (l[i][0]-l[i-1][0])<(l[i][1]-l[i-1][1]):
                    f=1
                    break
                # if l[i][0]==l[i-1][0] and l[i][1]!=l[i-1][1]:
                #     f=1
                #     break
            else:
                f=1
                break
        if l[0][0]<l[0][1]:
            f=1
    if f==1:
        print('NO')
    else:
        print('YES')