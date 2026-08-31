for _ in range(int(input())):
    n = int(input())
    grid = []
    ans = 0 
    for i in range(n):
        grid.append([j for j in str(input())])
        # print(grid)

    first_left = [1,2]
    col_ah = [2,1]

    last_right = [n,n-1]
    col_pre = [n-1,n]

    ans = []

    if grid[0][1] == grid[n-1][n-2]  == grid[1][0] == grid[n-2][n-1] : 
        ans.append(last_right)
        ans.append(col_pre)
    
    elif grid[0][1] == grid[1][0] and  grid[n-1][n-2] == grid[n-2][n-1] and grid[n-2][n-1] != grid[0][1] :
        pass

    elif grid[0][1] != grid[1][0]  and  grid[n-1][n-2] != grid[n-2][n-1] : 

        if grid[0][1] != grid[n-1][n-2] :
            ans = [first_left, last_right]
        
        else :
            ans = [first_left, col_pre]
    
    elif grid[0][1] == grid[1][0] and grid[n-1][n-2] != grid[n-2][n-1] : 
        
        if grid[0][1] == grid[n-1][n-2] : 
            ans = [last_right]
        
        else : 
            ans = [col_pre]
    
    elif grid[0][1] != grid[1][0] and grid[n-1][n-2] == grid[n-2][n-1] : 

        if grid[0][1] == grid[n-1][n-2] : 
            ans = [first_left]
        
        else :
            ans = [col_ah]
    
    print(len(ans))
    for z in ans : 
        print(" ".join([str(b) for b in z]))