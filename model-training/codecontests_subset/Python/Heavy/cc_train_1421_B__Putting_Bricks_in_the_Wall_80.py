for _ in range(int(input())):
    n = int(input())
    grid = []
    count = 0
    ans = []
    for i in range(n):
        grid.append(list(input()))
    if grid[0][1]=='0' and grid[1][0]=='0':
        if grid[n-2][n-1]!='1':
            count += 1
            ans.append([n-1,n])
        if grid[n-1][n-2]!='1':
            count +=1
            ans.append([n,n-1])
    elif grid[0][1]=='1' and grid[1][0]=='1':
        if grid[n-2][n-1]!='0':
            count += 1
            ans.append([n-1,n])
        if grid[n-1][n-2]!='0':
            count +=1
            ans.append([n,n-1])
    elif grid[n-2][n-1]=='1' and grid[n-1][n-2]=='1':
        if grid[0][1]!='0':
            count += 1
            ans.append([1,2])
        if grid[1][0]!='0':
            count += 1
            ans.append([2,1])
    elif grid[n-2][n-1]=='0' and grid[n-1][n-2]=='0':
        if grid[0][1]!='1':
            count += 1
            ans.append([1,2])
        if grid[1][0]!='1':
            count += 1
            ans.append([2,1])
    elif grid[1][0]=='0' and grid[0][1]=='1' and grid[n-2][n-1]=='1' and grid[n-1][n-2]=='0':
        count = 2
        ans.append([1,2])
        ans.append([n,n-1])
    elif grid[1][0]=='0' and grid[0][1]=='1' and grid[n-2][n-1]=='0' and grid[n-1][n-2]=='1':
        count = 2
        ans.append([1,2])
        ans.append([n-1,n])
    elif grid[1][0]=='1' and grid[0][1]=='0' and grid[n-2][n-1]=='0' and grid[n-1][n-2]=='1':
        count = 2
        ans.append([2,1])
        ans.append([n-1,n])
    elif grid[1][0]=='1' and grid[0][1]=='0' and grid[n-2][n-1]=='1' and grid[n-1][n-2]=='0':
        count = 2
        ans.append([2,1])
        ans.append([n,n-1])
    if count:
        print(count)
        for i in ans:
            print(*i)
    else:
        print(count)

        
