import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    grid = []
    for i in range(n):
        grid.append(list(input())[:-1])
    cnt = 0
    ans = []
    if grid[0][1] == grid[1][0] == "0":
        if grid[n-2][n-1] == "0":
            ans.append((n-1,n))
            cnt += 1
        if grid[n-1][n-2] == "0":
            ans.append((n,n-1))
            cnt += 1
    elif grid[0][1] == grid[1][0] == "1":
        if grid[n-2][n-1] == "1":
            ans.append((n-1,n))
            cnt += 1
        if grid[n-1][n-2] == "1":
            ans.append((n,n-1))
            cnt += 1
    elif grid[n-2][n-1] == grid[n-1][n-2] == "0":
        if grid[0][1] == "0":
            ans.append((1,2))
            cnt += 1
        if grid[1][0] == "0":
            ans.append((2,1))
            cnt += 1
    elif grid[n-2][n-1] == grid[n-1][n-2] == "1":
        if grid[0][1] == "1":
            ans.append((1,2))
            cnt += 1
        if grid[1][0] == "1":
            ans.append((2,1))
            cnt += 1
    else:
        if grid[0][1] == "1":
            ans.append((1,2))
            cnt += 1
        if grid[1][0] == "1":
            ans.append((2,1))
            cnt += 1
        if grid[n-2][n-1] == "0":
            ans.append((n-1,n))
            cnt += 1
        if grid[n-1][n-2] == "0":
            ans.append((n,n-1))
            cnt += 1
    print(cnt)
    for i in range(cnt):
        print(ans[i][0],ans[i][1])




