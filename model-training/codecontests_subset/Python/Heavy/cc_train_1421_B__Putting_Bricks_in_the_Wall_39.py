        
t=int(input())
for _ in range(t):
    n=int(input())
    grid=[]
    for i in range(n):
        grid.append(list(input()))
    #print(grid)
    top1=grid[0][1]
    top2=grid[1][0]
    down1=grid[n-2][n-1]
    down2=grid[n-1][n-2]
    if(top1=='0' and top2=='0'):
        if(down1=='0' and down2=='0'):
            print(2)
            print(1,2)
            print(2,1)
        elif(down1=='0' and down2=='1'):
            print(1)
            print(n-1,n)
        elif(down1=='1' and down2=='0'):
            print(1)
            print(n,n-1)
        else:
            print(0)
    elif(top1=='1' and top2=='1'):
        if(down1=='0' and down2=='0'):
            print(0)
        elif(down1=='0' and down2=='1'):
            print(1)
            print(n,n-1)
        elif(down1=='1' and down2=='0'):
            print(1)
            print(n-1,n)
        else:
            print(2)
            print(1,2)
            print(2,1)
    elif(top1=='0' and top2=='1'):
        if(down1=='0' and down2=='0'):
            print(1)
            print(1,2)
        elif(down1=='0' and down2=='1'):
            print(2)
            print(n-1,n)
            print(2,1)
        elif(down1=='1' and down2=='0'):
            print(2)
            print(2,1)
            print(n,n-1)
        else:
            print(1)
            print(2,1)
    else:
        if(down1=='0' and down2=='0'):
            print(1)
            print(2,1)
        elif(down1=='0' and down2=='1'):
            print(2)
            print(n,n-1)
            print(2,1)
        elif(down1=='1' and down2=='0'):
            print(2)
            print(2,1)
            print(n-1,n)
        else:
            print(1)
            print(1,2)