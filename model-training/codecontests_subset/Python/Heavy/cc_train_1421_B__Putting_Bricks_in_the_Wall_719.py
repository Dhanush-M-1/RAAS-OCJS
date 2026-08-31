ans = []
for i in range(int(input())):
    n = int(input())
    
    grid = []
    for j in range(n):
        grid.append(input())
        
    s_right, s_down = int(grid[0][1]),     int(grid[1][0])
    f_left,  f_up   = int(grid[n-1][n-2]), int(grid[n-2][n-1])
    
    s_sum = s_right + s_down
    f_sum = f_left  + f_up
    
    if abs(f_sum - s_sum) == 2:
        ans.append('0')
    
    elif abs(f_sum - s_sum) == 1:
        ans.append('1')
        
        if f_sum == 2 or s_sum == 2:
            if s_sum == 1:
                if s_right == 1:
                    ans.append('1 2')
                else:
                    ans.append('2 1')       
            elif f_sum == 1:
                if f_left == 1:
                    ans.append(str(n) + ' ' + str(n-1))
                else:
                    ans.append(str(n-1) + ' ' + str(n))
                    
        else:
            if s_sum == 1:
                if s_right == 0:
                    ans.append('1 2')
                else:
                    ans.append('2 1')       
            elif f_sum == 1:
                if f_left == 0:
                    ans.append(str(n) + ' ' + str(n-1))
                else:
                    ans.append(str(n-1) + ' ' + str(n)) 
                    
    elif abs(f_sum - s_sum) == 0:
        ans.append('2')
        
        if s_sum == 0 or s_sum == 2:
            ans.append('1 2')
            ans.append('2 1')
        else:
            if s_right == 1:
                ans.append('1 2')
            else:
                ans.append('2 1')
                
            if f_left == 0:
                ans.append(str(n) + ' ' + str(n-1))
            else:
                ans.append(str(n-1) + ' ' + str(n))
            
        
print('\n'.join(ans))