for _ in range(int(input())):
    n = int(input())
    a = []
    for i in range(n):
        p,c = map(int,input().split())
        a.append((p,c))

    flag = 1
    if a[0][0]<a[0][1]:
        flag=0
        print('NO')
        continue

    i = 1
    while i<n:
        if a[i][0]>=a[i-1][0] and a[i][1]>=a[i-1][1] and a[i][0]-a[i-1][0]>=a[i][1]-a[i-1][1]:
            flag=1
        else:
            flag = 0
            break
        i+=1

    if flag==1:
        print('YES')
    else:
        print('NO')
