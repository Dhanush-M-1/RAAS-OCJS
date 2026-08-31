import sys
try:sys.stdin,sys.stdout=open('in.txt','r'),open('out.txt','w')
except:pass
ii1=lambda:int(sys.stdin.readline().strip()) # for interger
is1=lambda:sys.stdin.readline().strip() # for str
iia=lambda:list(map(int,sys.stdin.readline().strip().split())) # for List[int]
isa=lambda:sys.stdin.readline().strip().split() # for List[str]
mod=int(1e9 + 7);from collections import *;from math import *
###################### Start Here ######################

for i in range(ii1()):
    n=ii1()
    grid=[]
    for j in range(n):
        grid.append(is1())
    ans=[]
    if grid[0][1]==grid[1][0]:
        if grid[n-1][n-2]==grid[0][1]:
            ans.append([n,n-1])
        if grid[n-2][n-1]==grid[0][1]:
            ans.append([n-1,n])
    else:
        if grid[n-1][n-2]==grid[n-2][n-1]:
            if grid[n-1][n-2]==grid[0][1]:
                ans.append([1,2])
            if grid[n-1][n-2]==grid[1][0]:
                ans.append([2,1])
        else:
            if grid[0][1]=='1':
                ans.append([1,2])
            else:
                ans.append([2,1])
            if grid[n-1][n-2]=='0':
                ans.append([n,n-1])
            else:
                ans.append([n-1,n])
    print(len(ans))
    if ans:
        for a in ans:
            print(*a)
