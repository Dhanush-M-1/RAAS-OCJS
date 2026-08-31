for _ in range(int(input())):
    n=int(input())
    grid=[[None]*n]*n
    c=0
    changed=[]
    for i in range(n):
        grid[i]=list(input())
    if grid[0][1]==grid[1][0]:
        a=grid[0][1]
        if grid[n-1][n-2]==a:
            c+=1
            changed.append([n,n-1])
        if grid[n-2][n-1]==a:
            c+=1
            changed.append([n-1,n])
    elif grid[n-2][n-1]==grid[n-1][n-2]:
        a=grid[n-2][n-1]
        if grid[1][0]==a:
            c+=1
            changed.append([2,1])
        if grid[0][1]==a:
            c+=1
            changed.append([1,2])
    else:
        c=2
        changed.append([1,2])
        if grid[n-2][n-1]==grid[0][1]:
            changed.append([n,n-1])
        else:
            changed.append([n-1,n])
    print(c)
    for i in changed:
        print(*i)