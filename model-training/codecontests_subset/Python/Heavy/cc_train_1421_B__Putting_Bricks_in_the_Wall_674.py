import bisect

def solve(grid):
    #print(grid)
    oneone = grid[0][1]
    twoone = grid[1][0]
    lastleft = grid[-1][-2]
    lastup = grid[-2][-1]
    ans = []
    n = len(grid)
    if oneone == twoone:
        if lastleft == oneone:
            ans.append([n,n-1])
            pass
        if lastup == oneone:
            ans.append([n-1,n])
            pass
    else:
        if lastleft == lastup:
            if lastleft == oneone:
                ans.append([1,2])
                pass
            if lastleft == twoone:
                ans.append([2,1])
                pass
        else:
            oneone = twoone
            ans.append([1,2])
            if lastleft == oneone:
                ans.append([n, n - 1])
                pass
            if lastup == oneone:
                ans.append([n - 1, n])
                pass
    return ans
    pass



t = int(input())
ans = []
for i in range(t):
    n = int(input())
    #s = [int(x) for x in input().split()]
    #a = s[0]
    #b = s[1]
    grid = []
    for j in range(n):
        grid.append(list(input()))
    ans.append(solve(grid))

# print(ans)
for test in ans:
    print(len(test))
    for ans in test:
        for ele in ans:
            print(ele,end=" ")
        print()

