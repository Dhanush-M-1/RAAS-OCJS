import sys
input = sys.stdin.readline
n,m,k=[int(x) for x in input().split()]
maze=[]
for z in range(n):
    arr=list(input())
    maze.append(arr)
s,cnt,first=0,0,0
for i in range(n):
    for j in range(m):
        if maze[i][j]==".":
            s+=1 
            if first==0:
                p,q=i,j 
                first=1 
            
def DFS(i, j):
    global n, m, k,s
    adj = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    stack = [[i, j]]
    t=s-k
    if t>0:
        maze[i][j]="Y"
        t=t-1
    while stack :
        if t <= 0 :
            return
        i, j = stack[-1][0], stack[-1][1]
        stack.pop()
        for pair in adj:
            x,y = i + pair[0], j+ pair[1]
            if 0 <= x < n and 0 <= y < m and maze[x][y] == ".":
                if t <= 0 :
                    return
                maze[x][y] = "Y"
                t=t-1 
                stack.append([x,y])
                
if s and k>0:
    DFS(p,q)
if k>0:
    for i in range(n):
        for j in range(m):
            if maze[i][j]==".":
                maze[i][j]="X"
            elif maze[i][j]=='Y':
                maze[i][j]="."
            
for i in range(n):
    s=""
    for j in range(m):
        s=s+maze[i][j]
    print(s)