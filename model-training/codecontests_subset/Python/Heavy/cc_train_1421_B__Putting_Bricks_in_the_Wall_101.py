for _ in range (int(input())):
    n = int(input())
    grid = []
    for i in range (n):
        grid.append(list(input()))
    s1 = grid[0][1]
    s2 = grid[1][0]
    e1 = grid[n-2][n-1]
    e2 = grid[n-1][n-2]
    ans = []
    if s1 == s2:
        if e1 == s1:
            ans.append([n-1,n])
        if e2 == s2:
            ans.append([n,n-1])
    else:
        if e1!=e2:
            if s1=='1':
                ans.append([2,1])
            else:
                ans.append([1,2])
            if e1=='1':
                ans.append([n-1,n])
            else:
                ans.append([n,n-1])
        else:
            if e1=='0':
                if s1=='1':
                    ans.append([2,1])
                else:
                    ans.append([1,2])
            else:
                if s1=='0':
                    ans.append([2,1])
                else:
                    ans.append([1,2])
    print(len(ans))
    for i in ans:
        print(*i)