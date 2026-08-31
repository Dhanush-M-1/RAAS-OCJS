import math
from decimal import *
import random
                
for _ in range(int(input())):
    n = int(input())
    grid = []
    for i in range(n):
        grid.append(list(input()))
    if(grid[0][1]=='0' and grid[1][0]=='0'):
        no= 0
        ans = []
        if(grid[n-1][n-2]=='0'):
            no+=1
            ans.append([str(n), str(n-1)])
        if(grid[n-2][n-1]=='0'):
            no+=1
            ans.append([str(n-1), str(n)])
        print(no)
        for i in range(no):
            print(' '.join(ans[i]))
    elif(grid[0][1]=='1' and grid[1][0]=='1'):
        no= 0
        ans = []
        if(grid[n-1][n-2]=='1'):
            no+=1
            ans.append([str(n), str(n-1)])
        if(grid[n-2][n-1]=='1'):
            no+=1
            ans.append([str(n-1), str(n)])
        print(no)
        for i in range(no):
            print(' '.join(ans[i]))
    elif(grid[n-2][n-1]=='0' and grid[n-1][n-2]=='0'):
        no= 0
        ans = []
        if(grid[0][1]=='0'):
            no+=1
            ans.append([str(1), str(2)])
        if(grid[1][0]=='0'):
            no+=1
            ans.append([str(2), str(1)])
        print(no)
        for i in range(no):
            print(' '.join(ans[i]))
    elif(grid[n-2][n-1]=='1' and grid[n-1][n-2]=='1'):
        no= 0
        ans = []
        if(grid[0][1]=='1'):
            no+=1
            ans.append([str(1), str(2)])
        if(grid[1][0]=='1'):
            no+=1
            ans.append([str(2), str(1)])
        print(no)
        for i in range(no):
            print(' '.join(ans[i]))
    else:
        ans = []
        if(grid[1][0]!= grid[0][1]):
            if(grid[n-1][n-2]!= grid[n-2][n-1]):
                if(grid[n-2][n-1]==grid[0][1]):
                    ans.append(['1', '2'])
                    ans.append([str(n), str(n-1)])
                if(grid[n-2][n-1]==grid[1][0]):
                    ans.append(['1', '2'])
                    ans.append([str(n-1), str(n)])
        print(len(ans))
        for x in ans:
            print(' '.join(x))