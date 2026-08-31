t = int(input())

for ti in range(t):
    n = int(input())
    grid = []
    for tn in range(n):
        grid.append(input())

    bord = [ grid[1][0], grid[0][1], grid[n-1][n-2], grid[n-2][n - 1] ]

    ans = []
    for ls in [ [ '0', '0' , '1' , '1'], ['1', '1', '0', '0' ]]:
        ans = []
        for i in range(4):
            if ls[i] != bord[i]:
                ans.append(i)
        
        if len(ans) <= 2 :
            break
    
    print(len(ans))
    if ans:
        for i in ans:
            x, y =  [(2,1),(1,2),(n, n - 1), (n - 1, n )][i]
            print(x, y)