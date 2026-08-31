import sys
input = sys.stdin.readline

t = int(input())
for i in range(t):
    n = int(input())
    s = [list(input()) for _ in range(n)]
    start = [s[0][1],s[1][0]]
    goal = [s[n-1][n-2],s[n-2][n-1]]
    ans = []
    if goal[0] == goal[1]:
        memo = goal[0]
        if start[0] == memo:
            ans.append([1,2])
        if start[1] == memo:
            ans.append([2,1])
    else:
        memo = start[0]
        if start[1] != memo:
            ans.append([2,1])
        if goal[0] == memo:
            ans.append([n,n-1])
        if goal[1] == memo:
            ans.append([n-1,n])
    print(len(ans))
    for j in ans:
        print(j[0],j[1])