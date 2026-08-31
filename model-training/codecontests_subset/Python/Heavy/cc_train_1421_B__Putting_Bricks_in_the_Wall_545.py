
import math
# import sys
from collections import Counter, defaultdict, deque

#def BFS(start, grid):
    
    

def f(n, grid):
    r1c2 = grid[0][1]
    r2c1 = grid[1][0]

    up = grid[n-2][n-1]
    left = grid[n-1][n-2]

    if(r1c2 == r2c1 and up == left):
        if r1c2 != up:
            return[0]
        else:
            return([2, "{0} {1}".format(2,1), "{0} {1}".format(1,2)])
    elif(r1c2 != r2c1 and up == left):
        if(r1c2 != up):
            return([1, "{0} {1}".format(2,1)])
        else:
            return([1, "{0} {1}".format(1,2)])
    elif(r1c2 == r2c1 and up != left):
        if(r1c2 != up):
            return([1, "{0} {1}".format(n,n-1)])
        else:
            return([1, "{0} {1}".format(n-1,n)])
    else:
        #1,2
        if(r1c2 != up):
            #left
            return([2, "{0} {1}".format(2,1), "{0} {1}".format(n, n-1)])
        else:
            #up
            return([2, "{0} {1}".format(2,1), "{0} {1}".format(n-1,n)])

    

    
    


t = int(input())
result = []
for i in range(t):
    n = int(input())
    grid = []
    for row in range(n):
        grid.append(input())
    result.append(f(n, grid))
#print(result)
for i in range(t):
    print(result[i][0])
    for j in range(result[i][0]):
        print(result[i][j+1])
