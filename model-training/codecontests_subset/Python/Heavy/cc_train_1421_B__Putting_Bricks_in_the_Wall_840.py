for _ in range(int(input())):
    n=int(input())
    grid = [input() for i in range(n)]
    p=[]
 
    count = 0
    if grid[0][1] == '0' and grid[1][0] == '0' and grid[n-1][n-2] == '1' and grid[n-2][n-1] == '1':
        print(0)
        continue
    elif grid[0][1] == '1' and grid[1][0] == '1' and grid[n-1][n-2] == '0' and grid[n-2][n-1] == '0':
        print(0)
        continue
    elif grid[0][1] == '0' and grid[1][0] == '0':
        if grid[n-1][n-2] != '1':
            count+=1
            p.append((n-1,n-2))
        if grid[n-2][n-1] != '1':
            count+=1
            p.append((n-2,n-1))
    elif grid[0][1] == '1' and grid[1][0] == '1':
        if grid[n-1][n-2] != '0':
            count+=1
            p.append((n-1,n-2))
        if grid[n-2][n-1] != '0':
            count+=1
            p.append((n-2,n-1))
    elif grid[n-1][n-2] == '0' and grid[n-2][n-1] == '0':
        if grid[0][1] != '1':
            count+=1
            p.append((0,1))
        if grid[1][0] != '1':
            count+=1
            p.append((1,0))
    elif grid[n-1][n-2] == '1' and grid[n-2][n-1] == '1':
        if grid[0][1] != '0':
            count+=1
            p.append((0,1))
        if grid[1][0] != '0':
            count+=1
            p.append((1,0))
    elif grid[0][1] == '0' and grid[1][0] == '1':
        if grid[n-1][n-2] == '1' and grid[n-2][n-1] == '1':
            p.append((1,0))
            count+=1
        elif grid[n-1][n-2] == '0' and grid[n-2][n-1] == '0':
            p.append((0,1))
            count+=1
        elif grid[n-1][n-2] == '1' and grid[n-2][n-1] == '0':
            p.append((n-1,n-2))
            p.append((0,1))
            count+=2
        elif grid[n-1][n-2] == '0' and grid[n-2][n-1] == '1':
            p.append((1,0))
            p.append((n-1,n-2))
            count+=2
    elif grid[0][1] == '1' and grid[1][0] == '0':
        if grid[n-1][n-2] == '1' and grid[n-2][n-1] == '1':
            p.append((0,1))
            count+=1
        elif grid[n-1][n-2] == '0' and grid[n-2][n-1] == '0':
            p.append((1,0))
            count+=1
        elif grid[n-1][n-2] == '1' and grid[n-2][n-1] == '0':
            p.append((n-1,n-2))
            p.append((1,0))
            count+=2
        elif grid[n-1][n-2] == '0' and grid[n-2][n-1] == '1':
            p.append((1,0))
            p.append((n-2,n-1))
            count+=2
    elif grid[n-1][n-2] == '0' and grid[n-2][n-1] == '1':
        if grid[0][1] == '1' and grid[1][0] == '1':
            p.append((n-1,n-2))
            count+=1
        elif grid[0][1] == '0' and grid[1][0] == '0':
            p.append((n-1,n-2))
            count+=1
        elif grid[0][1] == '1' and grid[1][0] == '0':
            p.append((1,0))
            p.append((n-2,n-1))
            count += 2     
        else:
            p.append((0,1))
            p.append((n-1,n-2))
            count+=1
 
    print(count)
    #print(p)
    for i in p:
        print(i[0]+1,i[1]+1)
