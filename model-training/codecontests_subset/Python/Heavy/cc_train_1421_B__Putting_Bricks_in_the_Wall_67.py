for _ in range(int(input())):
    n = int(input())
    arr= []
    for i in range(n):
        arr.append(input())
    s1 = arr[0][1]
    s2 = arr[1][0]
    e1 = arr[n-2][n-1]
    e2 = arr[n-1][n-2]
    ans = []
    if(s1==s2):
        if(e1==s1):
            ans.append((n-2,n-1))
        if(e2==s1):
            ans.append((n-1,n-2))
    else:
        if(e1==e2):
            if(s1==e1):
                ans.append((0,1))
            if(s2==e1):
                ans.append((1,0))
        else:
            ans.append((0,1))
            if(e1==s2):
                ans.append((n-2,n-1))
            else:
                ans.append((n-1,n-2))
    print(len(ans))
    for point in ans:
        print(point[0]+1, point[1]+1)