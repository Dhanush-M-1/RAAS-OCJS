import sys
from collections import defaultdict

#input driver
name = sys.stdin.read()

jobGrid = []
isJob = True
row = []

grid = name.split('\n') 

grid = grid[:-1]

number_of_cases = int(grid[0])

for i in range(number_of_cases):
    l = list(map(int,grid[i+1].split()))[0]
    ans = 0
    multiply = 0
    while(l != 1):
        if(l % 6 != 0):
            if(multiply == 1):
                break
            l *= 2
            multiply = 1
        else:
            l /= 6
            multiply = 0
        ans += 1
    if(l != 1):
        print(-1)
    else:
        print(ans)
