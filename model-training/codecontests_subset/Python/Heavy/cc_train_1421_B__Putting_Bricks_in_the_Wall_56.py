for _ in range(int(input())):
    n = int(input())
    l = []
    for i in range(n):
        a = input()
        l.append(a)
    ans = []
    if l[0][1]==l[1][0]:
        if l[0][1]=='1':
            if l[n-2][n-1]=='1':
                ans.append([n-1,n])
            if l[n-1][n-2]=='1':
                ans.append([n,n-1])
        else:
            if l[n-2][n-1]=='0':
                ans.append([n-1,n])
            if l[n-1][n-2]=='0':
                ans.append([n,n-1])
    elif l[n-2][n-1]==l[n-1][n-2]:
        if l[n-2][n-1]=='1':
            if l[0][1]=='1':
                ans.append([1,2])
            if l[1][0]=='1':
                ans.append([2,1])
        else:
            if l[0][1]=='0':
                ans.append([1,2])
            if l[1][0]=='0':
                ans.append([2,1])
    else:
        if l[0][1]!='0':
            ans.append([1,2])
        else:
            ans.append([2,1])
        if l[n-2][n-1]!='1':
            ans.append([n-1,n])
        else:
            ans.append([n,n-1])
    print(len(ans))
    for i in ans:
        print(i[0],i[1])
