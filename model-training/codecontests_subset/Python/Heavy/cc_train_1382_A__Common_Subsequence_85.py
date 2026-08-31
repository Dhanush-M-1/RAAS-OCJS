for _ in range(int(input())):
    l=list(map(int,input().split()))
    n=l[0]
    m=l[1]
    a1=list(map(int,input().split()))
    a2=list(map(int, input().split()))
    flag = False
    if n>m or n==m:
        for i in range(n):
            j=0
            while j < m:
                if a2[j]==a1[i]:
                    print('YES')
                    print('1 {}'.format(a2[j]))
                    flag=True
                    break
                j=j+1
            if flag==True:
                break
    else:
        for i in range(m):
            j = 0
            while j < n:
                if a2[i] == a1[j]:
                    print('YES')
                    print('1 {}'.format(a1[j]))
                    flag = True
                    break
                j = j + 1
            if flag==True:
                break

    if flag== False:
        print('NO')